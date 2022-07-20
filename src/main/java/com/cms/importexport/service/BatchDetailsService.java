package com.cms.importexport.service;

import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.Status;

public interface BatchDetailsService {

	Status saveBatchDetails(BatchDetailsDTO batchDetailsDTO);

	Status updateCloserDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	Status updateCorresDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	Status updatePermDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	Status updateBankDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	Status updateContactDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	Status updateIncomeDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO);

}
