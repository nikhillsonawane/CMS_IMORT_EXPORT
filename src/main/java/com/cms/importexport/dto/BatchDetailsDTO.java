package com.cms.importexport.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class BatchDetailsDTO {

	
	private	Long cmsBatchDetailsId;
	private	Long tradingBatchMastId;
	private	String barcode;
	private	String fileName;
	private	Long cmsCheckerId;
	private String requestType;
	
	private	String tradingExportStatus;
	private	String nsdlExportStatus;
	private	String cdslModificationExportStatus;
	private	String cdslClosureExportStatus;
	private	String kycAddressExportStatus;
	private	String kycMobileEmailExportStatus;
	private	String tradingImportStatus;
	private	String nsdlImportStatus;
	private	String cdslModificationImportStatus;
	private	String cdslClosureImportStatus;
	private	String kycAddressImportStatus;
	private	String kycMobileEmailImportStatus;
	
	private	Long accountCloserId;
	private	String closerDpId;
	private	String closerDpHolding;
	private	String closerTargetDepository;
	private	String closerTargetDpId;
	private	String closerTargetClientId;
	private	String closerPanNo;
	
	private	String addressCorresId;
	private	Long corresAccountType;
	private	String corresAdd1;
	private	String corresAdd2;
	private	String corresAdd3;
	private	String corresCountryId;
	private	Long corresStateId;
	private	Long corresCityId;
	private	Long corresZipId;
	private	String corresUserRemarks;
	
	private	Long addressPermId;
	private	Long permAccountType;
	private	String permAdd1;
	private	String permAdd2;
	private	String permAdd3 ;
	private	String permCountryId;
	private	Long permStateId;
	private	Long permCityId;
	private	Long permZipId;
	private	String permUserRemarks;
	
	private	Long bankId;
	private	Long accountType;
	private	String bankName;
	private	String bankIfscCode;
	private	String bankCode;
	private	String bankAccountType;
	private	String bankAccountNo;
	private	String bankAddress1;
	private	String bankAddress2;
	private	 String bankCity;
	private	String bankPincode;
	private	String bankMicrCode;
	private	String bankAccountCurrency;
	
	
	
	
	private	Long contactDetailsId;
	private	Long contactAccountType;
	private	 String emailIdFirstHolder;
	private	String ffFhForEmailId;
	private	String fhIsdCodeForMobileNo;
	private	String fhOfMobileNo;
	private	String fhFfForMobileNo;
	private	String shEmailId;
	private	String shFfForEmailId;
	private	String shIsdCodeForMobileNo;
	private	String shOfMobileNo;
	private	String shFfForMobileNo;
	private	String thEmailId;
	private	String thFfForEmailId;
	private	String thIsdCodeForMobileNo;
	private	String thOfMobileNo;
	private	String thFfForMobileNo;
	
	private	Long checkerIncomeRangeId;
	private	Long incomeType;
	private	String incomeRange;
	private	Long incomeRangeId;

	private	String tradingAccountNo;
	private	String dematAccountNo;
	
	private	Long tradingBatchId;
	private	Long nsdlBatchId;
	private	Long cdslModBatchId;
	private	Long cdslClosBatchId;
	private	Long kycAddBatchId;
	private	Long kycMobiMailBatchId;
	
}
