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
public class UpdateZipCasesDTO {

	private Long cmsBatchMastId;
	private String fileName;
	private Long totalCases;
}
