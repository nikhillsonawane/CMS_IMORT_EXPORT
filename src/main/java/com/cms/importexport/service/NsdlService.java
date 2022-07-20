package com.cms.importexport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.NsdlDao;
import com.cms.importexport.dao.NsdlMasterExport;
import com.cms.importexport.dto.BatchCountDetailsDTO;
import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.NsdlMasterExportDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.dto.UpdateZipCasesDTO;
import com.cms.importexport.model.PendingCases;
import com.cms.importexport.utils.CmsStringUtils;
import com.cms.importexport.utils.FileExport;
import com.cms.importexport.utils.NsdlFileHeader;

@Service
public class NsdlService {

	@Value("${baseFilePath}")
	private String baseFilePath;

	@Autowired
	NsdlDao nsdlDao;

	@Autowired
	NsdlMasterExport nsdlMasterExport;

	@Autowired
	NsdlFileHeader fileHeader;

	@Autowired
	FileExport fileexport;

	@Autowired
	BatchMasterService batchMasterService;

	@Autowired
	BatchCountDetailsService batchCountDetails;

	public void exportNSDL(Long batchMastId, String batchNumber) {
		try {

			List<BatchDetailsDTO> batchDetailsDTO = nsdlDao.getBatchDetailsId();
//		System.out.println(batchDetailsDTO);
			List<NsdlMasterExportDTO> nsdlMasterExportDTO = nsdlMasterExport.getNsdlMasterExport();
//        System.out.println(nsdlMasterExportDTO);

			List<String> exportNSDLStrList = new ArrayList<String>();

			String header = fileHeader.fileHeader(batchNumber, "Code12", "IN000009");
			exportNSDLStrList.add(header);

			int count = 0;
			for (Iterator iterator = batchDetailsDTO.iterator(); iterator.hasNext();) {
				BatchDetailsDTO batchDetailsDTOData = (BatchDetailsDTO) iterator.next();
//			System.out.println(batchDetailsDTOData);
				count++;
				String exportNSDLStr = "";
				for (Iterator it = nsdlMasterExportDTO.iterator(); it.hasNext();) {
					NsdlMasterExportDTO nsdlMasterExportDTOData = (NsdlMasterExportDTO) it.next();
//				System.out.println(nsdlMasterExportDTOData);

					String fieldName = nsdlMasterExportDTOData.getDescription();

					switch (fieldName) {
					case "Line Number":

						String lineNumber = CmsStringUtils.leftPadding("" + count, "0",
								nsdlMasterExportDTOData.getFieldSize());
						System.out.println(lineNumber);
						exportNSDLStr = exportNSDLStr + "" + lineNumber;
						break;
					case "Record Type":
						exportNSDLStr = exportNSDLStr + "01";

						break;

					case "Client ID":
						String clientId = CmsStringUtils.rightPadding(batchDetailsDTOData.getDematAccountNo(), " ", 8);
						exportNSDLStr = exportNSDLStr + "" + clientId;
						System.out.println(exportNSDLStr);
						break;
					case "Beneficiary Short name":
						String beneficiaryShortName = CmsStringUtils.rightPadding(batchDetailsDTOData.getBankName(),
								" ", 16);
						break;
					case "Beneficiary Occupation Code ":

						break;
					default:
						break;
					}

				}
				exportNSDLStrList.add(exportNSDLStr);
//System.out.println(exportNSDLStr);
				Long batchDetailsId = batchDetailsDTOData.getCmsBatchDetailsId();
				nsdlDao.updateTradingExportStatus(batchDetailsId, batchMastId);
			}
//			System.out.println("Size" + exportNSDLStrList.size());
			try {

				String nsdlFile = fileexport.NsdlFileNameGenerated(batchNumber);
				File theDir = new File(baseFilePath + "/NSDL/NSDL_" + batchMastId);
				if (!theDir.exists()) {
					theDir.mkdirs();
				}
				savaTextFile(baseFilePath + "/NSDL/NSDL_" + batchMastId + "/" + nsdlFile + ".txt", exportNSDLStrList,
						true);
				BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
				long createdBy = 11;
				long countRecords = count;
				String fileName = nsdlFile + ".txt";
				batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
				batchCountDetailsDTO.setFileName(fileName);
				batchCountDetailsDTO.setRecordCount(countRecords);
				batchCountDetailsDTO.setStatus("EXPORT");
				batchCountDetailsDTO.setCreatedBy(createdBy);
				batchCountDetailsDTO.setLastUpdateLogin(createdBy);
				batchCountDetailsDTO.setLastUpdatedBy(createdBy);
				batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);

			} catch (IOException e) {
			}

			try {
				fileexport.zipFolder(baseFilePath + "/NSDL/NSDL_" + batchMastId,
						baseFilePath + "/NSDL/NSDL_" + batchMastId + ".zip");
			} catch (Exception e) {
				e.printStackTrace();
			}

			UpdateZipCasesDTO updateZipCasesDTO = new UpdateZipCasesDTO();
			long totalCases = batchDetailsDTO.size();
			String zipFileName = "NSDL_" + batchMastId + ".zip";
			updateZipCasesDTO.setCmsBatchMastId(batchMastId);
			updateZipCasesDTO.setFileName(zipFileName);
			updateZipCasesDTO.setTotalCases(totalCases);
			batchMasterService.updateZipAndCases(updateZipCasesDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void savaTextFile(String fileName, List<String> text, boolean append) throws IOException {

		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);

		Writer output = new BufferedWriter(fw);
		for (Iterator iterator = text.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			output.write(string + "\n");
		}

		output.close();

	}

	public Long countResultNsdl(ResultBatchMasterDTO resultBatchMasterDTO) {
		Long pendingCount = nsdlDao.countResultNsdlAll(resultBatchMasterDTO);
		return pendingCount;
	}

	public List<PendingCases> searchResultNsdl(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> listOfPendingAll = nsdlDao.searchResultNsdlAll(resultBatchMasterDTO);
		return listOfPendingAll;
	}

}
