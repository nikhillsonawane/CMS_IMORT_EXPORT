package com.cms.importexport.utils;

public class CdslModHeader {

public static String cdslFileHeader(String dpId , String operatorId , long totalNoOfRecordes){
		
		
		String csdlHeader = dpId + operatorId + totalNoOfRecordes ;
		System.out.println(csdlHeader);
		return csdlHeader;
		
	}
}
