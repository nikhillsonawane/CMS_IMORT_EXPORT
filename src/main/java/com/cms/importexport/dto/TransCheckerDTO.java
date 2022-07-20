package com.cms.importexport.dto;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class TransCheckerDTO {
	private	Long cms_checker_id;
	private	Long cms_data_entry_id;
	private	Long cms_scrutiny_id;
	private	Long cms_case_initiation_id;
	private	String barcode;
	private	String trading_account_no;
	private	String demat_account_no;
	private	String request_type;
	private	String checker_status;
	private	String checkerRemark;
	private	String rejectionRemarks;
	private	String branchCode;
	private	String employeeCodeRm;
	private Date lastUpdateDate;
	private	String status;
	private	Long createdBy;
	private Date creationDate;
	private	String lastUpdateLogin;
	private	String lastUpdatedBy;
	private	String panNo;
	private	String fileUpload1;
	private	String fileUpload2;
	private	String fileUpload3;
	private	String allocatedTo;
	private	String clientNameTrading;
	private	String clientNameDemat;
	private	String awbNo;
	private	String isUserExist;
	private	String requestTypeStr;
	private	String customerEmail;
	private	String customerMobile;
	private	String changesApplicableTo;
	private	String otherRejectionRemark;
	private Date receiptDate;
	private	String branchCodeEmail;
	private	String docReceived;
	private	String requesttypeOther;
	private	String bacode;
	private	String rejectionRemarkStr;
	private	Long tradingAccountNoOld;
	private	Long dematAccountNoOld;
	private	String importExportStatus;

}
