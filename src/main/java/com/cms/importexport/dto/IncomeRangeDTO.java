package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class IncomeRangeDTO {
	private Long cmsCheckerId;
	private Long incomeType;
	private String incomeRange;
	private Long incomeRangeId;
}
