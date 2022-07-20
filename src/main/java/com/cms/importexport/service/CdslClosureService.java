package com.cms.importexport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.CdslClosureDao;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

@Service
public class CdslClosureService {

	@Autowired
	CdslClosureDao cdslClosureDao;

	public Long countResultCdslClosure(ResultBatchMasterDTO resultBatchMasterDTO) {
		Long pendingCount = cdslClosureDao.countResultCdslClosAll(resultBatchMasterDTO);
		return pendingCount;
	}

	public List<PendingCases> searchResultCdslClosure(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> listOfPendingAll = cdslClosureDao.searchResultCdslClosAll(resultBatchMasterDTO);
		return listOfPendingAll;
	}

}
