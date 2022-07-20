package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class CdslModExportDTO {

	private Long cmsCdslModExport_id;
	private String fieldDescription;
	private Long lineNo;
	private String fieldName;
	private String dataType;
	private Long fieldSize;
	private String fieldStatus;
	private Long fieldSequence;
	private String requestTypeTable;
	private String status;
}
