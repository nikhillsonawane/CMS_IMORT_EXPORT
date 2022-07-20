package com.cms.importexport.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class NsdlFileHeader {
	public static void main(String args[]) {

		NsdlFileHeader.fileHeader("12345678", "Code12", "IN000009");

	}

	public static String fileHeader(String batchNumber, String branchCodeBaseBranch, String dpId) {
		String recordType = "01";
		String bpRole = "01";
		String senderReferenceNumber = "";
		String senderReferenceNumberRight = CmsStringUtils.rightPadding(senderReferenceNumber, " ", 35);
		String pattern = "yyyyMMdd";
		String senderDate = new SimpleDateFormat(pattern).format(new Date());

		String fileHeaderContent = batchNumber + recordType + branchCodeBaseBranch + dpId + bpRole
				+ senderReferenceNumberRight + senderDate;
		System.out.println(fileHeaderContent);
		return fileHeaderContent;
	}

}
