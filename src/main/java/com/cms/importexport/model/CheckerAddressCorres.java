package com.cms.importexport.model;

import java.sql.Date;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckerAddressCorres {

	private Long cmsCheckerAddressCorresId;
    private Long CmsCheckerId;
    private Long AccountType;
    private String Add1;
    private String Add2;
    private String Add3;
    private Long CountryId;
    private Long StateId;
    private Long CityId;
    private Long ZipId;
    private String UserRemarks;
    private String Status;
    private Long CreatedBy;
    private Date CreationDate;
    private Long LastUpdateLogin;
    private Long LastUpdateBy;
    private Date LastUpdateDate;
    
    static public class COLUMNS_NAMES {

        public static String CMS_CHECKER_ADDRESS_CORRES_ID = "CMS_CHECKER_CORRES_ID";
        public static String CMS_CHECKER_ID = "CMS_CHECKER_ID";
        public static String ACCOUNT_TYPE = "ACCOUNT_TYPE";
        public static String ADD1 = "ADD1";
        public static String ADD2 = "ADD2";
        public static String ADD3 = "ADD3";
        public static String COUNTRY_ID = "COUNTRY_ID";
        public static String STATE_ID = "STATE_ID";
        public static String CITY_ID = "CITY_ID";
        public static String ZIP_ID = "ZIP_ID";
        public static String USER_REMARKS = "USER_REMARKS";
        public static String STATUS = "STATUS";
        public static String CREATED_BY = "CREATED_BY";
        public static String CREATION_DATE = "CREATION_DATE";
        public static String LAST_UPDATE_LOGIN = "LAST_UPDATE_LOGIN";
        public static String LAST_UPDATE_BY = "LAST_UPDATE_LOGIN";
        public static String LAST_UPDATE_DATE = "LAST_UPDATE_DATE";
    }
}
