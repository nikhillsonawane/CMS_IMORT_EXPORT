package com.cms.importexport.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.DataTable;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.dto.Status;
import com.cms.importexport.dto.TransCheckerDTO;
import com.cms.importexport.service.BatchMasterService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/batchMaster")
public class BatchMasterController {

	@Autowired
	BatchMasterService batchService;

	@RequestMapping(value = "/searchBatchMaster", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<DataTable> searchBatchMaster(@RequestBody BatchMasterDTO batchMasterDTO,
			HttpServletRequest request) {
		Integer userId = Integer.parseInt(request.getHeader("userId"));
		System.out.println("userId"+userId);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("access_token", request.getHeader("access_token"));

		ResponseEntity<DataTable> responseEntity = new ResponseEntity<DataTable>(
				batchService.searchBatchMaster(batchMasterDTO),responseHeaders, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/saveBatchMaster", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Status> saveBatchMaster(@RequestBody BatchMasterDTO batchMasterDTO,
			HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(batchService.saveBatchMaster(batchMasterDTO),
				HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/resultBatchMaster", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Status> resultBatchMaster(@RequestBody ResultBatchMasterDTO resultBatchMasterDTO,
			HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(batchService.resultBatchMaster(resultBatchMasterDTO),
				HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/updateBatchMaster/{batchId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updateBatchMaster(@PathVariable("batchId") Long batchId,
			@RequestBody BatchMasterDTO batchMasterDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updateBatchMaster(batchId, batchMasterDTO), HttpStatus.OK);
		return responseEntity;
	}
}