package com.cms.importexport.model;

import java.util.Date;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckerBankDetails {

	private Long cmsCheckerBankDetailsId;
    private Long cmsCheckerId;
    private Long accountType;
    private String bankName;
    private String bankIfscCode;
    private String bankCode;
    private String bankAccountType;
    private String bankAccountNo;
    private String bankAddress1;
    private String bankAddress2;
    private String bankCity;
    private String bankPincode;
    private String bankMicrCode;
    private String accountCurrency;
    private String status;
    private Long createdBy;
    private Date creationDate;
    private Long lastUpdateLogin;
    private Long lastUpdatedBy;
    private Date lastUpdateDate;
    
    static public class COLUMNS_NAMES {
        public static String CMS_CHECKER_BANK_DETAILS_ID = "CMS_CHECKER_BANK_ID";
        public static String CMS_CHECKER_ID = "CMS_CHECKER_ID";
        public static String ACCOUNT_TYPE = "ACCOUNT_TYPE";
        public static String BANK_NAME = "BANK_NAME";
        public static String BANK_IFSC_CODE = "BANK_IFSC_CODE";
        public static String BANK_CODE = "BANK_CODE";
        public static String BANK_ACCOUNT_TYPE = "BANK_ACCOUNT_TYPE";
        public static String BANK_ACCOUNT_NO = "BANK_ACCOUNT_NO";
        public static String BANK_ADDRESS1 = "BANK_ADDRESS1";
        public static String BANK_ADDRESS2 = "BANK_ADDRESS2";
        public static String BANK_CITY = "BANK_CITY";
        public static String BANK_PINCODE = "BANK_PINCODE";
        public static String BANK_MICR_CODE = "BANK_MICR_CODE";
        public static String ACCOUNT_CURRENCY = "ACCOUNT_CURRENCY";
        public static String STATUS = "STATUS";
        public static String CREATED_BY = "CREATED_BY";
        public static String CREATION_DATE = "CREATION_DATE";
        public static String LAST_UPDATE_LOGIN = "LAST_UPDATE_LOGIN";
        public static String LAST_UPDATED_BY = "LAST_UPDATED_BY";
        public static String LAST_UPDATE_DATE = "LAST_UPDATE_DATE";
    }


}
