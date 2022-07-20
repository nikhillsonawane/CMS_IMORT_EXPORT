package com.cms.importexport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.KycMobileEmailDao;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

@Service
public class KycMobileEmailService {

	@Autowired
	KycMobileEmailDao kycMobileEmailDao;

	public Long countResultMobileEmail(ResultBatchMasterDTO resultBatchMasterDTO) {
		Long pendingCount = kycMobileEmailDao.countResultMobileEmailAll(resultBatchMasterDTO);
		return pendingCount;
	}

	public List<PendingCases> searchResultMobileEmail(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> listOfPendingAll = kycMobileEmailDao.searchResultMobileEmailAll(resultBatchMasterDTO);
		return listOfPendingAll;
	}

	public void exportKycMobileEmail(Long batchMastId, String batchNumber) {
		// TODO Auto-generated method stub
		
	}

}
