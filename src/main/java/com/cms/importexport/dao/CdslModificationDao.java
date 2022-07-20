package com.cms.importexport.dao;

import java.util.List;

import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.CdslModExportDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

public interface CdslModificationDao {

	List<BatchDetailsDTO> getBatchDetailsId();

	void updateNsdlModExportStatus(Long batchDetailsId, Long batchMastId);

	List<CdslModExportDTO> getCdslModExport();

	Long countResultCdslModAll(ResultBatchMasterDTO resultBatchMasterDTO);

	List<PendingCases> searchResultCdslModAll(ResultBatchMasterDTO resultBatchMasterDTO);

}
