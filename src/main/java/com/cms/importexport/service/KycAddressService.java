package com.cms.importexport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.KycAddressDao;
import com.cms.importexport.dto.BatchCountDetailsDTO;
import com.cms.importexport.dto.BatchIdRequestTypeDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;
import com.cms.importexport.utils.FileExport;
import com.cms.importexport.utils.KycAddHeader;

@Service
public class KycAddressService {

	@Value("${baseFilePath}")
	private String baseFilePath;

	@Autowired
	FileExport fileexport;

	@Autowired
	KycAddressDao kycAddressDao;

	public Long countResultKycAdd(ResultBatchMasterDTO resultBatchMasterDTO) {
		Long pendingCount = kycAddressDao.countResultKycAddAll(resultBatchMasterDTO);
		return pendingCount;
	}

	public List<PendingCases> searchResultKycAdd(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> listOfPendingAll = kycAddressDao.searchResultKycAddAll(resultBatchMasterDTO);
		return listOfPendingAll;
	}

	public void exportKycAddress(Long batchMastId, String batchNumber) {
		Date date = new Date();
		Long ldate = date.getTime();

		List<BatchIdRequestTypeDTO> batchDetailsDTOList = kycAddressDao.getBatchDetailsId();

		List<String> dataList = new ArrayList<>();

		String h = KycAddHeader.kycAddFileHeader();
		dataList.add(h);

		int srNo = 0;
		for (Iterator iterator = batchDetailsDTOList.iterator(); iterator.hasNext();) {
			BatchIdRequestTypeDTO batchIdRequestTypeDTO = (BatchIdRequestTypeDTO) iterator.next();

			srNo++;
			System.out.println(batchIdRequestTypeDTO);
			String data = "\n" + srNo ;

			dataList.add(data);

		}

		try {

			String closerFile = fileexport.tradingFileNameGenerated("1", batchNumber);

			File theDir = new File(baseFilePath + "/KYCAddress/KYCAddress_" + batchMastId);
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			savaTextFile(baseFilePath + "/KYCAddress/KYCAddress_" + batchMastId + "/" + closerFile + ".csv",
					dataList, true);

		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileexport.zipFolder(baseFilePath + "/KYCAddress/KYCAddress_" + batchMastId,
					baseFilePath + "/KYCAddress/KYCAddress_" + batchMastId + ".zip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(dataList);

	}

	public void savaTextFile(String fileName, List<String> text, boolean append) throws IOException {

		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);

		Writer output = new BufferedWriter(fw);
		for (Iterator iterator = text.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			output.write(string + ",");

		}

		output.close();

	}
}
