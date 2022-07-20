package com.cms.importexport.dao;

import java.util.List;

import com.cms.importexport.dto.BatchIdRequestTypeDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

public interface KycAddressDao {

	Long countResultKycAddAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<PendingCases> searchResultKycAddAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<BatchIdRequestTypeDTO> getBatchDetailsId();

}
