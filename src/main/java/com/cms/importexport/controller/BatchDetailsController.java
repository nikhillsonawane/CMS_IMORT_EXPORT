package com.cms.importexport.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.Status;
import com.cms.importexport.service.BatchDetailsService;

@RestController
@RequestMapping("/batchDetails")
public class BatchDetailsController {

	@Autowired
	BatchDetailsService batchService;

	@RequestMapping(value = "/saveBatchDetails", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Status> saveBatchDetails(@RequestBody BatchDetailsDTO batchDetailsDTO,
			HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(batchService.saveBatchDetails(batchDetailsDTO),
				HttpStatus.OK);
		return responseEntity;

	}

	@RequestMapping(value = "/updateCloserDetails/{checkerId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updateCloserDetails(@PathVariable("checkerId") Long checkerId,
			@RequestBody BatchDetailsDTO batchDetailsDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updateCloserDetails(checkerId, batchDetailsDTO), HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/updateCorresDetails/{checkerId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updateCorresDetails(@PathVariable("checkerId") Long checkerId,
			@RequestBody BatchDetailsDTO batchDetailsDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updateCorresDetails(checkerId, batchDetailsDTO), HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/updatePermDetails/{checkerId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updatePermDetails(@PathVariable("checkerId") Long checkerId,
			@RequestBody BatchDetailsDTO batchDetailsDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updatePermDetails(checkerId, batchDetailsDTO), HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/updateBankDetails/{checkerId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updateBankDetails(@PathVariable("checkerId") Long checkerId,
			@RequestBody BatchDetailsDTO batchDetailsDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updateBankDetails(checkerId, batchDetailsDTO), HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/updateContactDetails/{checkerId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updateContactDetails(@PathVariable("checkerId") Long checkerId,
			@RequestBody BatchDetailsDTO batchDetailsDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updateContactDetails(checkerId, batchDetailsDTO), HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/updateIncomeDetails/{checkerId}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Status> updateIncomeDetails(@PathVariable("checkerId") Long checkerId,
			@RequestBody BatchDetailsDTO batchDetailsDTO, HttpServletRequest request) {

		ResponseEntity<Status> responseEntity = new ResponseEntity<>(
				batchService.updateIncomeDetails(checkerId, batchDetailsDTO), HttpStatus.OK);
		return responseEntity;
	}

}
