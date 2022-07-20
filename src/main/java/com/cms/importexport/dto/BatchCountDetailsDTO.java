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
public class BatchCountDetailsDTO {
	
	private Long cmsBatchCountDetailsId;
	private Long cmsBatchMastId;
	private String fileName;
	private Long recordCount;
	private String status;
	private Date startDate;
	private Date endDate;
	private Long createdBy;
	private Date creationDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private Date lastUpdateDate;
	
	public void getFileName(String string) {
		// TODO Auto-generated method stub
		
	}
}
