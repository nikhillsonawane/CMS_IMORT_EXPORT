package com.cms.importexport.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BatchMaster {

	private Long cmsBatchMastId;
	private String batchType;
	private String count;
	private String operatorId;
	private String batchNumber;
	private String status;
	private Date startDate;
	private Date endDate;
	private Long createdBy;
	private Date creationDate;
	private Long lastUpdateLogin;
	private Long lastUpdatedBy;
	private  Date  lastUpdateDate;
	private String fileName;
	private Long totalCases;
	private String filePath;
	
	static public class COLUMNS_NAMES {
		
		 public static final String CMS_BATCH_MAST_ID ="CMS_BATCH_MAST_ID";
		 public static final String BATCH_TYPE = "BATCH_TYPE";
		 public static final String COUNT="COUNT";
		 public static final String OPERATOR_ID = "OPERATOR_ID";
		 public static final String CURRENCY="CURRENCY";
		 public static final String  BATCH_NUMBER="BATCH_NUMBER";
		 public static final String STATUS="STATUS";
		 public static final String START_DATE="START_DATE";
		 public static final String END_DATE="END_DATE";
		 public static final String CREATED_BY= "CREATED_BY";
		 public static final String CREATION_DATE="CREATION_DATE";
		 public static final String LAST_UPDATE_LOGIN="LAST_UPDATE_LOGIN";
		 public static final String LAST_UPDATED_BY="LAST_UPDATED_BY";
		 public static final String LAST_UPDATE_DATE="LAST_UPDATE_DATE";
		 public static final String FILE_NAME = "FILE_NAME";
		 public static final String TOTAL_CASES = "TOTAL_CASES";
	}

	

	
}
