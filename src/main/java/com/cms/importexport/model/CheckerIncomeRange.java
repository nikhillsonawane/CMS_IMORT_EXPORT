package com.cms.importexport.model;

import java.util.Date;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CheckerIncomeRange {

	private Long cmsCheckerIncomeRangeId;
    private Long cmsCheckerId;
    private Long incomeType;
    private String incomeRange;
    private Long incomeRangeId;
    private String status;
    private Date creationDate;
    private Long lastUpdatedBy;
    private Date lastUpdateDate;
    private Long createdBy;
    private Long lastUpdateLogin;
    
    static public class COLUMNS_NAMES {
        public static String CMS_CHECKER_INCOME_RANGE_ID = "CMS_CHECKER_INCOME_RANGE_ID";
        public static String CMS_CHECKER_ID = "CMS_CHECKER_ID";
        public static String INCOME_TYPE = "INCOME_TYPE";
        public static String INCOME_RANGE = "INCOME_RANGE";
        public static String INCOME_RANGE_ID = "INCOME_RANGE_ID";
        public static String STATUS = "STATUS";
        public static String CREATION_DATE = "CREATION_DATE";
        public static String LAST_UPDATED_BY = "LAST_UPDATED_BY";
        public static String LAST_UPDATE_DATE = "LAST_UPDATE_DATE";
        public static String CREATED_BY = "CREATED_BY";
        public static String LAST_UPDATE_LOGIN = "LAST_UPDATE_LOGIN";
    }
}
