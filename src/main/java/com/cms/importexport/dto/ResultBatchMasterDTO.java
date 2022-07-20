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
public class ResultBatchMasterDTO {

	private String batchType;
	private String startDate;
	private String endDate;
	
	
	private	String barcode;
	private	Long cmsCheckerId;
	private	String tradingAccountNo;
	private	String dematAccountNo;
	private	String panNo;
	private	String receiptDate;
	
	private Long start;
    private Long length;
    private Integer columnSort;
    private Long pid;
}
