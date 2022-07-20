package com.cms.importexport.dto;



import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class BatchMasterDTO {

	private Long cmsBatchMastId;
	private String batchType;
	private String count;
	private String operatorId;
	private String batchNumber;
	private String status;
	private String startDate;
	private String endDate;
	private Long createdBy;
	private Date creationDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private  Date  lastUpdateDate;
	private String fileName;
	private Long totalCases;
	
	 private Long start;
	    private Long length;
	    private Integer columnSort;
	    private Long pid;
}
