package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class ContactDetailsDTO {
	private Long cmsCheckerId;
	private Long contactAccountType;
	private String emailIdFirstHolder;	
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

}
