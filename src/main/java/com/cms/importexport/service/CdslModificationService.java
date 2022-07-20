package com.cms.importexport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.CdslModificationDao;
import com.cms.importexport.dto.BatchCountDetailsDTO;
import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.CdslModExportDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.dto.UpdateZipCasesDTO;
import com.cms.importexport.model.PendingCases;
import com.cms.importexport.utils.CdslModFileExport;
import com.cms.importexport.utils.CdslModHeader;
import com.cms.importexport.utils.CmsStringUtils;
import com.cms.importexport.utils.FileExport;

@Service
public class CdslModificationService {

	@Value("${baseFilePath}")
	private String baseFilePath;

	@Autowired
	CdslModificationDao cdslModification;

	@Autowired
	FileExport fileexport;

	@Autowired
	BatchCountDetailsService batchCountDetails;

	@Autowired
	BatchMasterService batchMasterService;

	public void exportCdslModification(Long batchMastId, String batchNumber) {

		List<BatchDetailsDTO> batchDetailsDTO = cdslModification.getBatchDetailsId();
//		System.out.println(batchDetailsDTO);
		List<CdslModExportDTO> cdslModExportDTO = cdslModification.getCdslModExport();
//		System.out.println(cdslModExportDTO);
		List<String> exportCdslModificationStrList = new ArrayList<String>();

		String header = CdslModHeader.cdslFileHeader("dpID", "operatorId", 7);
		exportCdslModificationStrList.add(header);

		int count = 0;
		for (Iterator iterator = batchDetailsDTO.iterator(); iterator.hasNext();) {
			BatchDetailsDTO batchDetailsDTOData = (BatchDetailsDTO) iterator.next();
//			System.out.println(batchDetailsDTOData);

			count++;
			String exportCdslModStr = "";

			for (Iterator iterator2 = cdslModExportDTO.iterator(); iterator2.hasNext();) {
				CdslModExportDTO cdslModExportDTOData = (CdslModExportDTO) iterator2.next();
//				System.out.println(cdslModExportDTOData);

				String fieldDescription = cdslModExportDTOData.getFieldDescription();
				switch (fieldDescription) {
				case "ADDRESS 1":
					String address1 = CmsStringUtils.rightPadding(batchDetailsDTOData.getCorresAdd1(), " ", 55);
					exportCdslModStr = exportCdslModStr + address1;
					break;

				default:
					break;
				}
			}

			exportCdslModificationStrList.add(exportCdslModStr);

			Long batchDetailsId = batchDetailsDTOData.getCmsBatchDetailsId();
			cdslModification.updateNsdlModExportStatus(batchDetailsId, batchMastId);
		}
		try {

			String cdslFile = CdslModFileExport.cdslFileName("dpID", "serialNumber");

			File theDir = new File(baseFilePath + "\\CDSLModification\\CDSLModification_" + batchMastId);
			if (!theDir.exists()) {
				theDir.mkdirs();
			}
			savaTextFile(
					baseFilePath + "\\CDSLModification\\CDSLModification_" + batchMastId + "\\" + cdslFile + ".txt",
					exportCdslModificationStrList, true);

			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
			long createdBy = 11;
			long countRecords = count;
			String fileName = cdslFile + ".txt";
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

		UpdateZipCasesDTO updateZipCasesDTO = new UpdateZipCasesDTO();
		long totalCases = batchDetailsDTO.size();
		String zipFileName = "CDSLModification_" + batchMastId + ".zip";
		updateZipCasesDTO.setCmsBatchMastId(batchMastId);
		updateZipCasesDTO.setFileName(zipFileName);
		updateZipCasesDTO.setTotalCases(totalCases);
		batchMasterService.updateZipAndCases(updateZipCasesDTO);

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

	public Long countResultCdslMod(ResultBatchMasterDTO resultBatchMasterDTO) {
		Long pendingCount = cdslModification.countResultCdslModAll(resultBatchMasterDTO);
		return pendingCount;
	}

	public List<PendingCases> searchResultCdslMod(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> listOfPendingAll = cdslModification.searchResultCdslModAll(resultBatchMasterDTO);
		return listOfPendingAll;
	}

}
