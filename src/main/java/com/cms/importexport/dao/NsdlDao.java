package com.cms.importexport.dao;

import java.util.List;

import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;


public interface NsdlDao {

	List<BatchDetailsDTO> getBatchDetailsId();

	void updateTradingExportStatus(Long batchDetailsId,Long batchMastId);

	Long countResultNsdlAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<PendingCases> searchResultNsdlAll(ResultBatchMasterDTO resultBatchMasterDTO);

	

}
