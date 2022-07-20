package com.cms.importexport.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckerContactDetails {

	private Long cmsCheckerContactDetailsId;
    private Long cmsCheckerId;
    private Long accountType;
    private String fhEmailId;
    private String ffFhForEmailId;
    private String fhIsdCodeForMobileNo;
    private String fhOfMobileNo;
    private String fhFfForMobileNo;
    private String shEmailId;
    private String shFfForEmailId;
    private String shIsdCodeForMobileNo;
    private String shOfMobileNo;
    private String shFfForMobileNo;
    private String thEmailId;
    private String thFfForEmailId;
    private String thIsdCodeForMobileNo;
    private String thOfMobileNo;
    private String thFfForMobileNo;
    private String status;
    private Long createdBy;
    private Date creationDate;
    private Long lastUpdateLogin;
    private Long lastUpdateBy;
    private Date lastUpdateDate;
    
    static public class COLUMNS_NAMES {
        public static final String CMS_CHECKER_CONTACT_DETAILS_ID = "CMS_CHECKER_CONTACT_DETAILS_ID";
        public static String CMS_CHECKER_ID = "CMS_CHECKER_ID";
        public static final String ACCOUNT_TYPE = "ACCOUNT_TYPE";
        public static final String FH_EMAIL_ID = "EMAIL_ID_FIRST_HOLDER";
        public static final String FF_FH_FOR_EMAIL_ID = "FF_FH_FOR_EMAIL_ID";
        public static final String FH_ISD_CODE_FOR_MOBILE_NO = "FH_ISD_CODE_FOR_MOBILE_NO";
        public static final String FH_OF_MOBILE_NO = "FH_OF_MOBILE_NO";
        public static final String FH_FF_FOR_MOBILE_NO = "FH_FF_FOR_MOBILE_NO";
        public static final String SH_EMAIL_ID = "SH_EMAIL_ID";
        public static final String SH_FF_FOR_EMAIL_ID = "SH_FF_FOR_EMAIL_ID";
        public static final String SH_ISD_CODE_FOR_MOBILE_NO = "SH_ISD_CODE_FOR_MOBILE_NO";
        public static final String SH_OF_MOBILE_NO = "SH_OF_MOBILE_NO";
        public static final String SH_FF_FOR_MOBILE_NO = "SH_FF_FOR_MOBILE_NO";
        public static final String TH_EMAIL_ID = "TH_EMAIL_ID";
        public static final String TH_FF_FOR_EMAIL_ID = "TH_FF_FOR_EMAIL_ID";
        public static final String TH_ISD_CODE_FOR_MOBILE_NO = "TH_ISD_CODE_FOR_MOBILE_NO";
        public static final String TH_OF_MOBILE_NO = "TH_OF_MOBILE_NO";
        public static final String TH_FF_FOR_MOBILE_NO = "TH_FF_FOR_MOBILE_NO";
        public static final String STATUS = "STATUS";
        public static final String CREATED_BY = "CREATED_BY";
        public static final String CREATION_DATE = "CREATION_DATE";
        public static final String LAST_UPDATE_LOGIN = "LAST_UPDATE_LOGIN";
        public static final String LAST_UPDATE_BY = "LAST_UPDATE_BY";
        public static final String LAST_UPDATE_DATE = "LAST_UPDATE_DATE";
    }

}
