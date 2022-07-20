package com.cms.importexport.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PendingCases {

	private	Long cmsBatchDetailsId;
	private	String barcode;
	private	Long cmsCheckerId;
	private	String tradingAccountNo;
	private	String dematAccountNo;
	private	String panNo;
	private	String receiptDate;
	
	static public class COLUMNS_NAMES {
		public static final String CMS_BATCH_DETAILS_ID = "CMS_BATCH_DETAILS_ID";
		public static final String BARCODE = "BARCODE";
		public static final String CMS_CHECKER_ID = "CMS_CHECKER_ID";
		public static final String TRADING_ACCOUNT_NO = "TRADING_ACCOUNT_NO";
		public static final String DEMAT_ACCOUNT_NO = "DEMAT_ACCOUNT_NO";
		public static final String PAN_NO = "PAN_NO";
		public static final String RECEIPT_DATE = "RECEIPT_DATE";
	}
}
