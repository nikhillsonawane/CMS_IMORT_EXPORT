package com.cms.importexport.utils;

public class KycAddHeader {
	
	public static String kycAddFileHeader() {
		
		String header = "Sr No,	" + "Flag to indicate record N- New O-Existing," + "PAN," + "Name of the Applicant,"
				+ "IPV Flag(Y if IPV is done else N)," + "Name of the person doing the IPV,"
				+ "Designation of the person doing the IPV," + "Organization Name of the person doing the IPV,"
				+ "Date of the IPV DD/MM/YYYY," + "Father's/Husband's  Name," + "Gender (‘M’ – Male ‘F’ – Female),"
				+ "Marital status(‘S’ – Single ‘M’ – Married)," + "Date of Birth (DD/MM/YYYY)," + "UID,"
				+ "Status (Individual) 01-Resident Individual 02-Non Resident 03-Foreign National,"
				+ "Nationality 01-Indian 99-Other," + "Nationality (For Other),	"
				+ "Proof of Identity submitted(Kindly refer sheet POI submitted),	"
				+ "Proof of Identity submitted (Others)," + "Correspondence Address (Line 1),"
				+ "Correspondence Address (Line 2)," + "Correspondence Address (Line 3)," + "City / Town / Village,"
				+ "PIN Code," + "State," + "State (Others)," + "Country,"
				+ "Proof of Address submitted for correspondence address (Kindly refer sheet POA submitted),"
				+ "Proof of Address submitted for correspondence address (Others)," + "Tel. (Off.)," + "Tel. (Res.),"
				+ "Mobile No.," + "Fax No.," + "Email ID,"
				+ "Flag indicating if Permanent Address is same as correspondence Address (Y- Yes N- No),"
				+ "Permanent Address (Line 1)," + "Permanent Address (Line 2)," + "Permanent Address (Line 3),"
				+ "City / Town / Village," + "PIN Code," + "State," + "State (Others)," + "Country,"
				+ "Proof of Address submitted for permnent address (Kindly refer sheet POA submitted),"
				+ "Proof of Address submitted for permanent address (Others),"
				+ "Gross Annual Income Range 01-Below Rs. 1  Lac 02-Btw Rs. 1 to Rs. 5 Lacs 03-Btw Rs. 5 to Rs. 10 Lacs 04-Btw Rs. 10 to Rs. 25 Lacs 05-More than Rs. 25 Lacs,"
				+ "Net Worth (In Rs.)," + "Net Worth as on Date DD/MM/YYYY,	"
				+ "Politically Exposed Person (PEP) 00-Not Applicable 01-PEP 02-Related to a PEP,"
				+ "Occupation 01-Public Sector 02-Private Sector 03-Government Service 04-Business 05-Professional 06-Agriculturist 07-Retired 08-Housewife 09-Student 99-Others,	"
				+ "Occupation Details (For Others),	" + "Any Other Information," + "Date of Declaration DD/MM/YYYY,"
				+ "Document received Date at Intermediary DD/MM/YYYY," + "No Of Documents Submitted,"
				+ "Client Activation Date DD/MM/YYYY," + "Client Updation Date DD/MM/YYYY," + "KYC Type";
		
		return header;
		
	}

}
