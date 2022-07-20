package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class BankDetailsDTO {
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
	private String bankAccountCurrency;	

}
