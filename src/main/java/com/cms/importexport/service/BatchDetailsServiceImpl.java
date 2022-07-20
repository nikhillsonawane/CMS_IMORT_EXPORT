package com.cms.importexport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.BatchDetailsDao;
import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.Status;

@Service
public class BatchDetailsServiceImpl implements BatchDetailsService {

	@Autowired
	BatchDetailsDao batchDao;

	@Override
	public Status saveBatchDetails(BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		long batchDetails = batchDao.saveBatchDetailsAll(batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updateCloserDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		batchDao.updateCloserDetailsAll(checkerId, batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updateCorresDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		batchDao.updateCorresDetailsAll(checkerId, batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updatePermDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		batchDao.updatePermDetailsAll(checkerId, batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updateBankDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		batchDao.updateBankDetailsAll(checkerId, batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updateContactDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		batchDao.updateContactDetailsAll(checkerId, batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

	@Override
	public Status updateIncomeDetails(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		Status status = new Status();
		batchDao.updateIncomeDetailsAll(checkerId, batchDetailsDTO);
		status.setMessage("Success");
		return status;
	}

}
