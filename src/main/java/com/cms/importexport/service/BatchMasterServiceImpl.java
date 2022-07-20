package com.cms.importexport.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.BatchMasterDao;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.DataTable;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.dto.Status;
import com.cms.importexport.dto.UpdateZipCasesDTO;
import com.cms.importexport.model.BatchMaster;
import com.cms.importexport.model.PendingCases;

@Service
public class BatchMasterServiceImpl implements BatchMasterService {

	@Autowired
	BatchMasterDao batchDao;

	@Autowired
	TradingService tradingService;

	@Autowired
	NsdlService nsdlService;

	@Autowired
	CdslModificationService cdslModificationService;

	@Autowired
	CdslClosureService cdslClosureService;

	@Autowired
	KycAddressService kycAddressService;

	@Autowired
	KycMobileEmailService kycMobileEmailService;

	@Override
	public DataTable searchBatchMaster(BatchMasterDTO batchMasterDTO) {

		DataTable dataTable = new DataTable();
		Long count = batchDao.countBatchMaster(batchMasterDTO);
		List<BatchMaster> listBatch = batchDao.searchBatchMasterAll(batchMasterDTO);
		dataTable.setRecordsTotal(count);

		List<BatchMaster> newList = new ArrayList<BatchMaster>();

		for (Iterator iterator = listBatch.iterator(); iterator.hasNext();) {
			BatchMaster batchMaster = (BatchMaster) iterator.next();

			String batchType = batchMaster.getBatchType().toUpperCase();

			switch (batchType) {
			case "TRADING":

				batchMaster.setFilePath("/Export/Trading/");
				newList.add(batchMaster);

				break;

			case "NSDL":
				batchMaster.setFilePath("/Export/NSDL/");
				newList.add(batchMaster);
				break;

			case "CDSL MODIFICATION":
				batchMaster.setFilePath("/Export/CDSLModification/");
				newList.add(batchMaster);

				break;

			case "CDSL CLOSURE":
				batchMaster.setFilePath("/Export/CDSLClosure/");
				newList.add(batchMaster);
				break;

			case "KYC ADDRESS":
				batchMaster.setFilePath("/Export/KYCAddress/");
				newList.add(batchMaster);
				break;

			case "KYC MOBILE EMAIL":
				batchMaster.setFilePath("/Export/KYCMobileEmail/");
				newList.add(batchMaster);
				break;

			default:
				break;
			}

		}

		dataTable.setData(newList);
		return dataTable;

	}

	@Override
	public Status resultBatchMaster(ResultBatchMasterDTO resultBatchMasterDTO) {
		Status status = new Status();

		String batchType = resultBatchMasterDTO.getBatchType().toUpperCase();

		switch (batchType) {
		case "TRADING":
			Long tradingCount = tradingService.countResultTrading(resultBatchMasterDTO);
			List<PendingCases> tradingList = tradingService.searchResultTrading(resultBatchMasterDTO);
			status.setRecordCount(tradingCount);
			status.setData(tradingList);
			break;

		case "NSDL":
			Long nsdlCount = nsdlService.countResultNsdl(resultBatchMasterDTO);
			List<PendingCases> nsdlList = nsdlService.searchResultNsdl(resultBatchMasterDTO);
			status.setRecordCount(nsdlCount);
			status.setData(nsdlList);

			break;

		case "CDSL MODIFICATION":
			Long cdslModCount = cdslModificationService.countResultCdslMod(resultBatchMasterDTO);
			List<PendingCases> cdslModList = cdslModificationService.searchResultCdslMod(resultBatchMasterDTO);
			status.setRecordCount(cdslModCount);
			status.setData(cdslModList);
			break;

		case "CDSL CLOSURE":
			Long cdslClosureCount = cdslClosureService.countResultCdslClosure(resultBatchMasterDTO);
			List<PendingCases> cdslClosureList = cdslClosureService.searchResultCdslClosure(resultBatchMasterDTO);
			status.setRecordCount(cdslClosureCount);
			status.setData(cdslClosureList);
			break;

		case "KYC ADDRESS":
			Long kycAddressCount = kycAddressService.countResultKycAdd(resultBatchMasterDTO);
			List<PendingCases> kycAddressList = kycAddressService.searchResultKycAdd(resultBatchMasterDTO);
			status.setRecordCount(kycAddressCount);
			status.setData(kycAddressList);
			break;

		case "KYC MOBILE EMAIL":
			Long kycMobiMailCount = kycMobileEmailService.countResultMobileEmail(resultBatchMasterDTO);
			List<PendingCases> kyckycMobiMailList = kycMobileEmailService.searchResultMobileEmail(resultBatchMasterDTO);
			status.setRecordCount(kycMobiMailCount);
			status.setData(kyckycMobiMailList);
			break;

		default:
			break;
		}

		status.setMessage("Success");
		return status;
	}

	@Override
	public Status saveBatchMaster(BatchMasterDTO batchMasterDTO) {
		Status status = new Status();

		Long batchMastId = batchDao.saveBatchMasterAll(batchMasterDTO);
		String batchNumber = batchMasterDTO.getBatchNumber();
		String batchType = batchMasterDTO.getBatchType().toUpperCase();

		switch (batchType) {
		case "TRADING":
			tradingService.exportTrading(batchMastId, batchNumber);

			break;

		case "NSDL":
			nsdlService.exportNSDL(batchMastId, batchNumber);
			break;

		case "CDSL MODIFICATION":
			cdslModificationService.exportCdslModification(batchMastId, batchNumber);
			break;

		case "CDSL CLOSURE":
			break;

		case "KYC ADDRESS":
			kycAddressService.exportKycAddress(batchMastId, batchNumber);
			break;

		case "KYC MOBILE EMAIL":
			kycMobileEmailService.exportKycMobileEmail(batchMastId, batchNumber);
			break;

		default:
			break;
		}

		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updateBatchMaster(Long batchId, BatchMasterDTO batchMasterDTO) {
		Status status = new Status();
		batchDao.updateBatchMasterAll(batchId, batchMasterDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public void updateZipAndCases(UpdateZipCasesDTO updateZipCasesDTO) {
		batchDao.updateZipAndCasesAll(updateZipCasesDTO);

	}

}
