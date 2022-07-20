package com.cms.importexport.dao;

import com.cms.importexport.dto.BatchDetailsDTO;

public interface BatchDetailsDao {

	long saveBatchDetailsAll(BatchDetailsDTO batchDetailsDTO);

	void updateCloserDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	void updateCorresDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	void updatePermDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	void updateBankDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	void updateContactDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO);

	void updateIncomeDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO);

}
