package com.cms.importexport.service;

import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.DataTable;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.dto.Status;
import com.cms.importexport.dto.UpdateZipCasesDTO;

public interface BatchMasterService {

	DataTable searchBatchMaster(BatchMasterDTO batchMasterDTO);

	Status saveBatchMaster(BatchMasterDTO batchMasterDTO);

	Status updateBatchMaster(Long batchId, BatchMasterDTO batchMasterDTO);

	void updateZipAndCases(UpdateZipCasesDTO updateZipCasesDTO);

	Status resultBatchMaster(ResultBatchMasterDTO resultBatchMasterDTO);

}
