package com.cms.importexport.enums;

public enum BatchTypeExportEnum {
	trading("TRADING"),
	nsdl("NSDL"),
	cdsl_modification("CDSL MODIFICATION"),
	cdsl_closure("CDSL CLOSURE"),
	kyc_address("KYC ADDRESS"),
	kyc_mobile_email("KYC MOBILE EMAIL");
	
	private String type;
	  
    // getter method
    public String getType()
    {
        return this.type;
    }
  
    // enum constructor - cannot be public or protected
    private BatchTypeExportEnum(String type)
    {
        this.type = type;
    }
}
