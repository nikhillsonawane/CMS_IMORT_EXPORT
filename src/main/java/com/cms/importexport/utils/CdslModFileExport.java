package com.cms.importexport.utils;

public class CdslModFileExport {
	public static String cdslFileName(String dpId,String serialNumber) {
		String newSerialNumber = CmsStringUtils.leftPadding(serialNumber, "0", 5);
		String cdslFile = dpId + newSerialNumber;
		System.out.println(cdslFile);
		return cdslFile;
		
	}
}
