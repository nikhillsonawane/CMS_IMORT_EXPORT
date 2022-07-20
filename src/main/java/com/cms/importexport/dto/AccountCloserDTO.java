package com.cms.importexport.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class AccountCloserDTO {

	private Long cmsCheckerId;
	private String closerDpId;
	private String closerDpHolding;
	private String closerTargetDepository;
	private String closerTargetDpId;
	private String closerTargetClientId;
	private String closerPanNo;
	private String tcsCode;
	private String tradingClosureStatus;
	private	String tradingAccountNo;
	public int size(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

}
