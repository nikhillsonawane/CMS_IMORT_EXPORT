package com.cms.importexport.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.CdslClosureConstant;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/cdslClosureQueries.properties", ignoreResourceNotFound = true)
public class CdslClosureDaoImpl implements CdslClosureDao {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;

	@Override
	public Long countResultCdslClosAll(ResultBatchMasterDTO resultBatchMasterDTO) {
		String query = env.getProperty(CdslClosureConstant.COUNT_RESULT_CDSL_CLOS);
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
	public List<PendingCases> searchResultCdslClosAll(ResultBatchMasterDTO resultBatchMasterDTO) {
		List<PendingCases> list = new ArrayList<PendingCases>();

		try {
			

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

			String query = env.getProperty(CdslClosureConstant.SEARCH_RESULT_CDSL_CLOS);
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
