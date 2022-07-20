package com.cms.importexport.dao;

import java.util.List;

import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.UpdateZipCasesDTO;
import com.cms.importexport.model.BatchMaster;



public interface BatchMasterDao {

	Long countBatchMaster(BatchMasterDTO batchMasterDTO);

	List<BatchMaster> searchBatchMasterAll(BatchMasterDTO batchMasterDTO);

	long saveBatchMasterAll(BatchMasterDTO batchMasterDTO);

	void updateBatchMasterAll(Long batchId, BatchMasterDTO batchMasterDTO);

	void updateZipAndCasesAll(UpdateZipCasesDTO updateZipCasesDTO);

	



	

	

}
