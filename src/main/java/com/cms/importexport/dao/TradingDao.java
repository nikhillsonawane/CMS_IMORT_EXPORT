package com.cms.importexport.dao;

import java.util.Date;
import java.util.List;

import com.cms.importexport.dto.AccountCloserDTO;
import com.cms.importexport.dto.AddressCorresDTO;
import com.cms.importexport.dto.AddressPermDTO;
import com.cms.importexport.dto.BankDetailsDTO;
import com.cms.importexport.dto.BatchIdRequestTypeDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ContactDetailsDTO;
import com.cms.importexport.dto.IncomeRangeDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

public interface TradingDao {

	List<BatchIdRequestTypeDTO> getBatchDetailsId();

	AccountCloserDTO getAccountCloser(Long batchDetailsId);

	AddressCorresDTO getaddressCorres(Long batchDetailsId);

	AddressPermDTO getaddressPerm(Long batchDetailsId);

	BankDetailsDTO getBankDetails(Long batchDetailsId);

	ContactDetailsDTO getContactDetails(Long batchDetailsId);

	IncomeRangeDTO getIncomeRange(Long batchDetailsId);

	void updateTradingExportStatus(Long batchDetailsId, Long batchMastId);

	Long countResultTradingAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<PendingCases> searchResultTradingAll(ResultBatchMasterDTO resultBatchMasterDTO);

	

	

	

}
