package com.cms.importexport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.importexport.dao.BatchCountDetailsDao;
import com.cms.importexport.dto.BatchCountDetailsDTO;
import com.cms.importexport.dto.Status;

@Service
public class BatchCountDetailsService {

	@Autowired
	BatchCountDetailsDao batchCountDetailsService;

	public Status saveBatchCountDetailsService(BatchCountDetailsDTO batchCountDetailsDTO) {
		batchCountDetailsService.saveBatchCountDetailsServiceAll(batchCountDetailsDTO);

		return null;

	}
}
