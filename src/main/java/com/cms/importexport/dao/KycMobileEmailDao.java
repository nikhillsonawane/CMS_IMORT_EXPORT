package com.cms.importexport.dao;

import java.util.List;

import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

public interface KycMobileEmailDao {

	Long countResultMobileEmailAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<PendingCases> searchResultMobileEmailAll(ResultBatchMasterDTO resultBatchMasterDTO);

}
