package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class NsdlMasterExportDTO {
	
	private Long cmsNsdlMasterExportId;
	private String description;
	private String fieldName;
	private String dataType;
	private Long fieldSize;
	private Long fieldEnd;
	private String fieldStatus;	
	private String remarks;
	private Long fieldSequence;	
	private String requestTypeTable;	
	private String status;
}
