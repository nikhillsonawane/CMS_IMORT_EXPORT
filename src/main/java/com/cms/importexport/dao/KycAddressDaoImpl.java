package com.cms.importexport.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.KycAddressConstant;
import com.cms.importexport.constant.TradingConstant;
import com.cms.importexport.dto.BatchIdRequestTypeDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/KycAddressQueries.properties", ignoreResourceNotFound = true)
public class KycAddressDaoImpl implements KycAddressDao {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;

	@Override
	public List<BatchIdRequestTypeDTO> getBatchDetailsId() {
		List<BatchIdRequestTypeDTO> list = new ArrayList<BatchIdRequestTypeDTO>();
		try {
			String query = env.getProperty(TradingConstant.GET_ID_REQUEST_TYPE);
			list = jdbcTemplate.query(query, new Object[] {},
					new BeanPropertyRowMapper<BatchIdRequestTypeDTO>(BatchIdRequestTypeDTO.class));
		} catch (Exception e) {

		}
		return list;
	}

	@Override
	public Long countResultKycAddAll(ResultBatchMasterDTO resultBatchMasterDTO) {
		String query = env.getProperty(KycAddressConstant.COUNT_RESULT_KYC_ADD);
		Long countCases;

		String barcode = null;
		String trading_account_no = null;
		String demat_account_no = null;
		String pan_no = null;

		if (resultBatchMasterDTO.getBarcode() != null && !resultBatchMasterDTO.getBarcode().isEmpty()) {
			barcode = "%" + resultBatchMasterDTO.getBarcode() + "%";
		}

		if (resultBatchMasterDTO.getTradingAccountNo() != null
				&& !resultBatchMasterDTO.getTradingAccountNo().isEmpty()) {
			trading_account_no = "%" + resultBatchMasterDTO.getTradingAccountNo() + "%";
		}

		if (resultBatchMasterDTO.getDematAccountNo() != null
				&& !resultBatchMasterDTO.getDematAccountNo().isEmpty()) {
			demat_account_no = "%" + resultBatchMasterDTO.getDematAccountNo() + "%";
		}

		if (resultBatchMasterDTO.getPanNo() != null && !resultBatchMasterDTO.getPanNo().isEmpty()) {
			pan_no = "%" + resultBatchMasterDTO.getPanNo() + "%";
		}

		String subRange = "(to_date(A3.RECEIPT_DATE,'dd-MM-yy') between to_date('" + resultBatchMasterDTO.getStartDate()
				+ "','dd-MM-yy') and \r\n" + "to_date('" + resultBatchMasterDTO.getEndDate() + "','dd-MM-yy') ) ";
		query = query.replace("subRangeField", subRange);

		countCases = jdbcTemplate
				.queryForObject(
						query.toString(), new Object[] { barcode, resultBatchMasterDTO.getCmsCheckerId(),
								trading_account_no, demat_account_no, pan_no, resultBatchMasterDTO.getPid() },
						Long.class);
		return countCases;

	}

	@Override
	public List<PendingCases> searchResultKycAddAll(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> list = new ArrayList<PendingCases>();
		String query = env.getProperty(KycAddressConstant.SEARCH_RESULT_KYC_ADD);
		
		String barcode = null;
		String trading_account_no = null;
		String demat_account_no = null;
		String pan_no = null;

		if (resultBatchMasterDTO.getBarcode() != null && !resultBatchMasterDTO.getBarcode().isEmpty()) {
			barcode = "%" + resultBatchMasterDTO.getBarcode() + "%";
		}

		if (resultBatchMasterDTO.getTradingAccountNo() != null
				&& !resultBatchMasterDTO.getTradingAccountNo().isEmpty()) {
			trading_account_no = "%" + resultBatchMasterDTO.getTradingAccountNo() + "%";
		}

		if (resultBatchMasterDTO.getDematAccountNo() != null
				&& !resultBatchMasterDTO.getDematAccountNo().isEmpty()) {
			demat_account_no = "%" + resultBatchMasterDTO.getDematAccountNo() + "%";
		}

		if (resultBatchMasterDTO.getPanNo() != null && !resultBatchMasterDTO.getPanNo().isEmpty()) {
			pan_no = "%" + resultBatchMasterDTO.getPanNo() + "%";
		}
		String subRange = "(to_date(A3.RECEIPT_DATE,'dd-MM-yy') between to_date('" + resultBatchMasterDTO.getStartDate()
		+ "','dd-MM-yy') and \r\n" + "to_date('" + resultBatchMasterDTO.getEndDate() + "','dd-MM-yy') ) ";
query = query.replace("subRangeField", subRange);

list = jdbcTemplate.query(query.toString(), new Object[] {

		barcode, resultBatchMasterDTO.getCmsCheckerId(), trading_account_no, demat_account_no, pan_no,
		resultBatchMasterDTO.getPid(),

		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),
		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),
		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),
		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),
		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),
		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),
		resultBatchMasterDTO.getColumnSort(), resultBatchMasterDTO.getColumnSort(),

		resultBatchMasterDTO.getLength(), resultBatchMasterDTO.getStart() },
		new BeanPropertyRowMapper<PendingCases>(PendingCases.class));

return list;
	}

}
