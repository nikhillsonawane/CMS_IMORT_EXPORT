package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class AddressPermDTO {
	private Long cmsCheckerId;
	private Long permAccountType;	
	private String permAdd1;	
	private String permAdd2;	
	private String permAdd3;	
	private Long permCountryId;	
	private Long permStateId;	
	private Long permCityId; 
	private Long permZipId;	
	private String permUserRemarks;	

}
