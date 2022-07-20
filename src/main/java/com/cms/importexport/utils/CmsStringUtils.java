package com.cms.importexport.utils;

public class CmsStringUtils {

	public static String leftPadding(String input, String string, long L) {

		String result = String.format("%" + L + "s", input).replace(" ", string);
		return result;
	}
		
	public static String rightPadding(String input, String string, long L) {

		String result = String.format("%" + L + "s", input).replace(" ", string);
		return result;
	}
	// Driver code
	public static void main(String[] args) {

		String str = "a";
		String ch = "-";
		int L = 35;
		String fileHeaderContent = CmsStringUtils.leftPadding(str, ch, L);
		System.out.println(fileHeaderContent);

	}
}
