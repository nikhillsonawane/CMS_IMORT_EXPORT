package com.cms.importexport.dao;

import java.util.List;

import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

public interface CdslClosureDao {

	Long countResultCdslClosAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<PendingCases> searchResultCdslClosAll(ResultBatchMasterDTO resultBatchMasterDTO);

}
