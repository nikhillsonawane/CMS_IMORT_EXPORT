package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class BatchIdRequestTypeNsdlDTO {

	private	Long cmsBatchDetailsId;
	private String requestType;
}
