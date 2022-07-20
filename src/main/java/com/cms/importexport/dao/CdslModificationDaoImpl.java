package com.cms.importexport.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.CdslModificationConstant;
import com.cms.importexport.dto.BatchDetailsDTO;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.CdslModExportDTO;
import com.cms.importexport.dto.ResultBatchMasterDTO;
import com.cms.importexport.model.PendingCases;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/cdslModificationQueries.properties", ignoreResourceNotFound = true)
public class CdslModificationDaoImpl implements CdslModificationDao {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;

	@Override
	public List<BatchDetailsDTO> getBatchDetailsId() {
		List<BatchDetailsDTO> list = new ArrayList<BatchDetailsDTO>();
		try {
			String query = env.getProperty(CdslModificationConstant.GET_CDSL_STATUS_PENDING);
			list = jdbcTemplate.query(query, new Object[] {},
					new BeanPropertyRowMapper<BatchDetailsDTO>(BatchDetailsDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateNsdlModExportStatus(Long batchDetailsId, Long batchMastId) {

		Long batchDetailsIdUpdate = batchDetailsId;
		Long batchMasterId = batchMastId;
		String query = env.getProperty(CdslModificationConstant.UPDATE_CDSL_MOD_EXPORT_STATUS);
		try {
			jdbcTemplate.update(query, batchMasterId, batchDetailsIdUpdate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CdslModExportDTO> getCdslModExport() {
		List<CdslModExportDTO> cdslModExportDTOList = new ArrayList<>();
		try {
			String query = env.getProperty(CdslModificationConstant.GET_CDSL_MOD_EXPORT);
			cdslModExportDTOList = jdbcTemplate.query(query, new Object[] {},
					new BeanPropertyRowMapper<CdslModExportDTO>(CdslModExportDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cdslModExportDTOList;
	}

	@Override
	public Long countResultCdslModAll(ResultBatchMasterDTO resultBatchMasterDTO) {
		String query = env.getProperty(CdslModificationConstant.COUNT_RESULT_CDSL_MOD);
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
	public List<PendingCases> searchResultCdslModAll(ResultBatchMasterDTO resultBatchMasterDTO) {
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

		String query = env.getProperty(CdslModificationConstant.SEARCH_RESULT_CDSL_MOD);
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
