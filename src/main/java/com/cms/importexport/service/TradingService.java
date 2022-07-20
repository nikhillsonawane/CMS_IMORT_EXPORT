package com.cms.importexport.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.TradingDao;
import com.cms.importexport.dto.AccountCloserDTO;
import com.cms.importexport.dto.AddressCorresDTO;
import com.cms.importexport.dto.AddressPermDTO;
import com.cms.importexport.dto.BankDetailsDTO;
import com.cms.importexport.dto.BatchCountDetailsDTO;
import com.cms.importexport.dto.BatchIdRequestTypeDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ContactDetailsDTO;
import com.cms.importexport.dto.IncomeRangeDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.dto.UpdateZipCasesDTO;
import com.cms.importexport.model.PendingCases;
import com.cms.importexport.utils.FileExport;

@Service
public class TradingService {

	@Value("${baseFilePath}")
	private String baseFilePath;

	@Autowired
	FileExport fileexport;

	@Autowired
	TradingDao tradingDao;

	@Autowired
	BatchCountDetailsService batchCountDetails;

	@Autowired
	BatchMasterService batchMasterService;

	public void exportTrading(Long batchMastId, String batchNumber) {
		Date date = new Date();
		Long ldate = date.getTime();

		List<BatchIdRequestTypeDTO> batchDetailsDTOList = tradingDao.getBatchDetailsId();

		List<String> accountCloserStrList = new ArrayList<String>();
		List<String> addressCorresStrList = new ArrayList<String>();
		List<String> addressPermStrList = new ArrayList<String>();
		List<String> bankDetailsStrList = new ArrayList<String>();
		List<String> contactDetailsStrList = new ArrayList<String>();
		List<String> incomeRangeStrList = new ArrayList<String>();

		for (Iterator iterator = batchDetailsDTOList.iterator(); iterator.hasNext();) {
			BatchIdRequestTypeDTO batchIdRequestTypeDTO = (BatchIdRequestTypeDTO) iterator.next();

			if (batchIdRequestTypeDTO.getRequestType().contains(",2,")) {
				AccountCloserDTO accountCloserDTO = tradingDao
						.getAccountCloser(batchIdRequestTypeDTO.getCmsBatchDetailsId());

				String accountCloserData = accountCloserDTO.getTradingAccountNo() + "~" + accountCloserDTO.getTradingClosureStatus()
						+ "~" + accountCloserDTO.getTcsCode();
				accountCloserStrList.add(accountCloserData);
			}

//			if (batchIdRequestTypeDTO.getRequestType().contains(",3,")) {
//				AddressCorresDTO addressCorresDTO = tradingDao
//						.getaddressCorres(batchIdRequestTypeDTO.getCmsBatchDetailsId());
//
//				String addressCorresData = addressCorresDTO.getCmsCheckerId() + "~"
//						+ addressCorresDTO.getCorresAccountType() + "~" + addressCorresDTO.getCorresAdd1() + "~"
//						+ addressCorresDTO.getCorresAdd2() + "~" + addressCorresDTO.getCorresAdd3() + "~"
//						+ addressCorresDTO.getCorresCountryId() + "~" + addressCorresDTO.getCorresStateId() + "~"
//						+ addressCorresDTO.getCorresCityId() + "~" + addressCorresDTO.getCorresZipId() + "~"
//						+ addressCorresDTO.getCorresUserRemarks();
//				addressCorresStrList.add(addressCorresData);
//			}
//
//			if (batchIdRequestTypeDTO.getRequestType().contains(",88,")) {
//				AddressPermDTO addressPermDTO = tradingDao.getaddressPerm(batchIdRequestTypeDTO.getCmsBatchDetailsId());
//
//				String addressPermData = addressPermDTO.getCmsCheckerId() + "~" + addressPermDTO.getPermAccountType()
//						+ "~" + addressPermDTO.getPermAdd1() + "~" + addressPermDTO.getPermAdd2() + "~"
//						+ addressPermDTO.getPermAdd3() + "~" + addressPermDTO.getPermCountryId() + "~"
//						+ addressPermDTO.getPermStateId() + "~" + addressPermDTO.getPermCityId() + "~"
//						+ addressPermDTO.getPermZipId() + "~" + addressPermDTO.getPermUserRemarks();
//				addressPermStrList.add(addressPermData);
//			}
//
//			if (batchIdRequestTypeDTO.getRequestType().contains(",4,")) {
//				BankDetailsDTO bankDetailsDTO = tradingDao.getBankDetails(batchIdRequestTypeDTO.getCmsBatchDetailsId());
//
//				String bankDetailsData = bankDetailsDTO.getCmsCheckerId() + "~" + bankDetailsDTO.getAccountType() + "~"
//						+ bankDetailsDTO.getBankName() + "~" + bankDetailsDTO.getBankIfscCode() + "~"
//						+ bankDetailsDTO.getBankCode() + "~" + bankDetailsDTO.getBankAccountType() + "~"
//						+ bankDetailsDTO.getBankAccountNo() + "~" + bankDetailsDTO.getBankAddress1() + "~"
//						+ bankDetailsDTO.getBankAddress2() + "~" + bankDetailsDTO.getBankCity() + "~"
//						+ bankDetailsDTO.getBankPincode() + "~" + bankDetailsDTO.getBankMicrCode() + "~"
//						+ bankDetailsDTO.getBankPincode();
//				bankDetailsStrList.add(bankDetailsData);
//			}
//
//			if (batchIdRequestTypeDTO.getRequestType().contains(",7,")) {
//				ContactDetailsDTO contactDetailsDTO = tradingDao
//						.getContactDetails(batchIdRequestTypeDTO.getCmsBatchDetailsId());
//				String contactDetailsData = contactDetailsDTO.getCmsCheckerId() + "~"
//						+ contactDetailsDTO.getContactAccountType() + "~" + contactDetailsDTO.getEmailIdFirstHolder()
//						+ "~" + contactDetailsDTO.getFfFhForEmailId() + "~"
//						+ contactDetailsDTO.getFhIsdCodeForMobileNo() + "~" + contactDetailsDTO.getFhOfMobileNo() + "~"
//						+ contactDetailsDTO.getFhFfForMobileNo() + "~" + contactDetailsDTO.getShEmailId() + "~"
//						+ contactDetailsDTO.getShFfForEmailId() + "~" + contactDetailsDTO.getShIsdCodeForMobileNo()
//						+ "~" + contactDetailsDTO.getShOfMobileNo() + "~" + contactDetailsDTO.getShFfForMobileNo() + "~"
//						+ contactDetailsDTO.getThEmailId() + "~" + contactDetailsDTO.getThFfForEmailId() + "~"
//						+ contactDetailsDTO.getThIsdCodeForMobileNo() + "~" + contactDetailsDTO.getThOfMobileNo() + "~"
//						+ contactDetailsDTO.getThFfForMobileNo();
//				contactDetailsStrList.add(contactDetailsData);
//			}
//
//			if (batchIdRequestTypeDTO.getRequestType().contains(",11,")) {
//				IncomeRangeDTO incomeRangeDTO = tradingDao.getIncomeRange(batchIdRequestTypeDTO.getCmsBatchDetailsId());
//
//				String incomeRangeData = incomeRangeDTO.getCmsCheckerId() + "~" + incomeRangeDTO.getIncomeType() + "~"
//						+ incomeRangeDTO.getIncomeRange() + "~" + incomeRangeDTO.getIncomeRangeId();
//				incomeRangeStrList.add(incomeRangeData);
//			}

			Long batchDetailsId = batchIdRequestTypeDTO.getCmsBatchDetailsId();
			tradingDao.updateTradingExportStatus(batchDetailsId, batchMastId);

		}

		try {

			String closerFile = fileexport.tradingFileNameGenerated("1", batchNumber);

			File theDir = new File(baseFilePath + "/Trading/Trading_" + batchMastId);
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			savaTextFile(baseFilePath + "/Trading/Trading_" + batchMastId + "/" + closerFile + ".txt",
					accountCloserStrList, true);

			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
			accountCloserStrList.size();
			long createdBy = 11;
			long countRecords = accountCloserStrList.size();
			String fileName = closerFile + ".txt";
			batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
			batchCountDetailsDTO.setFileName(fileName);
			batchCountDetailsDTO.setRecordCount(countRecords);
			batchCountDetailsDTO.setStatus("EXPORT");
			batchCountDetailsDTO.setCreatedBy(createdBy);
			batchCountDetailsDTO.setLastUpdateLogin(createdBy);
			batchCountDetailsDTO.setLastUpdatedBy(createdBy);
			batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);

		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			String corrosFile = fileexport.tradingFileNameGenerated("2", batchNumber);
//			File theDir = new File(baseFilePath + "/Trading/Trading_" + batchMastId);
//			if (!theDir.exists()) {
//				theDir.mkdirs();
//			}
//			savaTextFile(baseFilePath + "/Trading/Trading_" + batchMastId + "/" + corrosFile + ".txt",
//					addressCorresStrList, true);
//
//			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
//			long createdBy = 11;
//			long countRecords = addressCorresStrList.size();
//			String fileName = corrosFile + ".txt";
//			batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
//			batchCountDetailsDTO.setFileName(fileName);
//			batchCountDetailsDTO.setRecordCount(countRecords);
//			batchCountDetailsDTO.setStatus("EXPORT");
//			batchCountDetailsDTO.setCreatedBy(createdBy);
//			batchCountDetailsDTO.setLastUpdateLogin(createdBy);
//			batchCountDetailsDTO.setLastUpdatedBy(createdBy);
//			batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		try {
//			String perFile = fileexport.tradingFileNameGenerated("3", batchNumber);
//			File theDir = new File(baseFilePath + "/Trading/Trading_" + batchMastId);
//			if (!theDir.exists()) {
//				theDir.mkdirs();
//			}
//			savaTextFile(baseFilePath + "/Trading/Trading_" + batchMastId + "/" + perFile + ".txt",
//					addressPermStrList, true);
//
//			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
//			long createdBy = 11;
//			long countRecords = addressPermStrList.size();
//			String fileName = perFile + ".txt";
//			batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
//			batchCountDetailsDTO.setFileName(fileName);
//			batchCountDetailsDTO.setRecordCount(countRecords);
//			batchCountDetailsDTO.setStatus("EXPORT");
//			batchCountDetailsDTO.setCreatedBy(createdBy);
//			batchCountDetailsDTO.setLastUpdateLogin(createdBy);
//			batchCountDetailsDTO.setLastUpdatedBy(createdBy);
//			batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			String bankFile = fileexport.tradingFileNameGenerated("4", batchNumber);
//			File theDir = new File(baseFilePath + "/Trading/Trading_" + batchMastId);
//			if (!theDir.exists()) {
//				theDir.mkdirs();
//			}
//			savaTextFile(baseFilePath + "/Trading/Trading_" + batchMastId + "/" + bankFile + ".txt",
//					bankDetailsStrList, true);
//
//			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
//			long createdBy = 11;
//			long countRecords = bankDetailsStrList.size();
//			String fileName = bankFile + ".txt";
//			batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
//			batchCountDetailsDTO.setFileName(fileName);
//			batchCountDetailsDTO.setRecordCount(countRecords);
//			batchCountDetailsDTO.setStatus("EXPORT");
//			batchCountDetailsDTO.setCreatedBy(createdBy);
//			batchCountDetailsDTO.setLastUpdateLogin(createdBy);
//			batchCountDetailsDTO.setLastUpdatedBy(createdBy);
//			batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			String contactFile = fileexport.tradingFileNameGenerated("5", batchNumber);
//			File theDir = new File(baseFilePath + "/Trading/Trading_" + batchMastId);
//			if (!theDir.exists()) {
//				theDir.mkdirs();
//			}
//			savaTextFile(baseFilePath + "/Trading/Trading_" + batchMastId + "/" + contactFile + ".txt",
//					contactDetailsStrList, true);
//
//			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
//			long createdBy = 11;
//			long countRecords = contactDetailsStrList.size();
//			String fileName = contactFile + ".txt";
//			batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
//			batchCountDetailsDTO.setFileName(fileName);
//			batchCountDetailsDTO.setRecordCount(countRecords);
//			batchCountDetailsDTO.setStatus("EXPORT");
//			batchCountDetailsDTO.setCreatedBy(createdBy);
//			batchCountDetailsDTO.setLastUpdateLogin(createdBy);
//			batchCountDetailsDTO.setLastUpdatedBy(createdBy);
//			batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			String incomeFile = fileexport.tradingFileNameGenerated("6", batchNumber);
//			File theDir = new File(baseFilePath + "/Trading/Trading_" + batchMastId);
//			if (!theDir.exists()) {
//				theDir.mkdirs();
//			}
//			savaTextFile(baseFilePath + "/Trading/Trading_" + batchMastId + "/" + incomeFile + ".txt",
//					incomeRangeStrList, true);
//
//			BatchCountDetailsDTO batchCountDetailsDTO = new BatchCountDetailsDTO();
//			long createdBy = 11;
//			long countRecords = incomeRangeStrList.size();
//			String fileName = incomeFile + ".txt";
//			batchCountDetailsDTO.setCmsBatchMastId(batchMastId);
//			batchCountDetailsDTO.setFileName(fileName);
//			batchCountDetailsDTO.setRecordCount(countRecords);
//			batchCountDetailsDTO.setStatus("EXPORT");
//			batchCountDetailsDTO.setCreatedBy(createdBy);
//			batchCountDetailsDTO.setLastUpdateLogin(createdBy);
//			batchCountDetailsDTO.setLastUpdatedBy(createdBy);
//			batchCountDetails.saveBatchCountDetailsService(batchCountDetailsDTO);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		try {
			fileexport.zipFolder(baseFilePath + "/Trading/Trading_" + batchMastId,
					baseFilePath + "/Trading/Trading_" + batchMastId + ".zip");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UpdateZipCasesDTO updateZipCasesDTO = new UpdateZipCasesDTO();
		long totalCases = batchDetailsDTOList.size();
		String zipFileName = "Trading_" + batchMastId + ".zip";
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

	public Long countResultTrading(ResultBatchMasterDTO resultBatchMasterDTO) {
		Long pendingCount = tradingDao.countResultTradingAll(resultBatchMasterDTO);
		return pendingCount;
	}

	public List<PendingCases> searchResultTrading(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> listOfPendingAll = tradingDao.searchResultTradingAll(resultBatchMasterDTO);
		return listOfPendingAll;
	}

}
