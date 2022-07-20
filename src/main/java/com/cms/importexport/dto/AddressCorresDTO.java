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
public class AddressCorresDTO {
	private Long cmsCheckerId;
	private Long corresAccountType;
	private String corresAdd1;
	private String corresAdd2;	
	private String corresAdd3;	
	private Long corresCountryId;	
	private Long corresStateId;
	private Long corresCityId;
	private Long corresZipId;
	private String corresUserRemarks;
}
