package com.cms.importexport.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.TradingConstant;
import com.cms.importexport.dto.AccountCloserDTO;
import com.cms.importexport.dto.AddressCorresDTO;
import com.cms.importexport.dto.AddressPermDTO;
import com.cms.importexport.dto.BankDetailsDTO;
import com.cms.importexport.dto.BatchIdRequestTypeDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ContactDetailsDTO;
import com.cms.importexport.dto.IncomeRangeDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.BatchMaster;
import com.cms.importexport.model.PendingCases;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/tradingQuerries.properties", ignoreResourceNotFound = true)
public class TradingDaoImpl implements TradingDao {

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
	public AccountCloserDTO getAccountCloser(Long batchDetailsId) {
		String query = env.getProperty(TradingConstant.GET_ACCOUNT_CLOSER);
		return jdbcTemplate.query(query, new Object[] { batchDetailsId },
				new BeanPropertyRowMapper<AccountCloserDTO>(AccountCloserDTO.class)).get(0);
	}

	@Override
	public AddressCorresDTO getaddressCorres(Long batchDetailsId) {
		String query = env.getProperty(TradingConstant.GET_ADDRESS_CORRES);
		return jdbcTemplate.query(query, new Object[] { batchDetailsId },
				new BeanPropertyRowMapper<AddressCorresDTO>(AddressCorresDTO.class)).get(0);
	}

	@Override
	public AddressPermDTO getaddressPerm(Long batchDetailsId) {
		String query = env.getProperty(TradingConstant.GET_ADDRESS_PERM);
		return jdbcTemplate.query(query, new Object[] { batchDetailsId },
				new BeanPropertyRowMapper<AddressPermDTO>(AddressPermDTO.class)).get(0);
	}

	@Override
	public BankDetailsDTO getBankDetails(Long batchDetailsId) {
		String query = env.getProperty(TradingConstant.GET_BANK_DETAILS);
		return jdbcTemplate.query(query, new Object[] { batchDetailsId },
				new BeanPropertyRowMapper<BankDetailsDTO>(BankDetailsDTO.class)).get(0);
	}

	@Override
	public ContactDetailsDTO getContactDetails(Long batchDetailsId) {
		String query = env.getProperty(TradingConstant.GET_CONTACT_DETAILS);
		return jdbcTemplate.query(query, new Object[] { batchDetailsId },
				new BeanPropertyRowMapper<ContactDetailsDTO>(ContactDetailsDTO.class)).get(0);
	}

	@Override
	public IncomeRangeDTO getIncomeRange(Long batchDetailsId) {
		String query = env.getProperty(TradingConstant.GET_INCOME_RANGE);
		return jdbcTemplate.query(query, new Object[] { batchDetailsId },
				new BeanPropertyRowMapper<IncomeRangeDTO>(IncomeRangeDTO.class)).get(0);
	}

	@Override
	public void updateTradingExportStatus(Long batchDetailsId, Long batchMastId) {
		Long batchDetailsIdUpdate = batchDetailsId;
		Long batchMasterId = batchMastId;
		String query = env.getProperty(TradingConstant.UPDATE_TRADING_EXPORT_STATUS);
		try {
			jdbcTemplate.update(query, batchMasterId, batchDetailsIdUpdate);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Long countResultTradingAll(ResultBatchMasterDTO resultBatchMasterDTO) {

		String query = env.getProperty(TradingConstant.COUNT_RESULT_TRADING);
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
	public List<PendingCases> searchResultTradingAll(ResultBatchMasterDTO resultBatchMasterDTO) {

		List<PendingCases> list = new ArrayList<PendingCases>();

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

		String query = env.getProperty(TradingConstant.SEARCH_RESULT_TRADING);
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
