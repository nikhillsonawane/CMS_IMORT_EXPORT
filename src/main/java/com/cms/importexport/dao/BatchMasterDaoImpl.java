package com.cms.importexport.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.cms.importexport.constant.BatchMasterConstant;
import com.cms.importexport.dto.BatchMasterDTO;
import com.cms.importexport.dto.UpdateZipCasesDTO;
import com.cms.importexport.model.BatchMaster;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/batchMasterQueries.properties", ignoreResourceNotFound = true)
public class BatchMasterDaoImpl implements BatchMasterDao {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;

	// SEARCH Count
	@Override
	public Long countBatchMaster(BatchMasterDTO batchMasterDTO) {

		try {
			String query = env.getProperty(BatchMasterConstant.BATCH_MASTER_COUNT);

			String batchType = null;
			String count = null;
			String operatorId = null;
			String batchNumber = null;
			String status = null;
			String fileName = null;

			if (batchMasterDTO.getBatchType() != null && !batchMasterDTO.getBatchType().isEmpty()) {
				batchType = "%" + batchMasterDTO.getBatchType() + "%";
			}
			if (batchMasterDTO.getCount() != null && !batchMasterDTO.getCount().isEmpty()) {
				count = "%" + batchMasterDTO.getCount() + "%";
			}
			if (batchMasterDTO.getOperatorId() != null && !batchMasterDTO.getOperatorId().isEmpty()) {
				operatorId = "%" + batchMasterDTO.getOperatorId() + "%";
			}

			if (batchMasterDTO.getBatchNumber() != null && !batchMasterDTO.getBatchNumber().isEmpty()) {
				batchNumber = "%" + batchMasterDTO.getBatchNumber() + "%";
			}
			if (batchMasterDTO.getStatus() != null && !batchMasterDTO.getStatus().isEmpty()) {
				status = "%" + batchMasterDTO.getStatus() + "%";
			}
			if (batchMasterDTO.getFileName() != null && !batchMasterDTO.getFileName().isEmpty()) {
				fileName = "%" + batchMasterDTO.getFileName() + "%";
			}

			Long countBatch = jdbcTemplate.queryForObject(query.toString(), new Object[] { batchType, count, operatorId,
					batchNumber, status, fileName, batchMasterDTO.getTotalCases(), batchMasterDTO.getPid() },
					Long.class);
			return countBatch;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}

	}

	// SEARCH BY PARAMETERS
	@Override
	public List<BatchMaster> searchBatchMasterAll(BatchMasterDTO batchMasterDTO) {

		List<BatchMaster> list = new ArrayList<BatchMaster>();
		String query = env.getProperty(BatchMasterConstant.BATCH_MASTER_SEARCH);

		list = jdbcTemplate.query(query.toString(),
				new Object[] { batchMasterDTO.getBatchType(), batchMasterDTO.getCount(), batchMasterDTO.getOperatorId(),
						batchMasterDTO.getBatchNumber(), batchMasterDTO.getStatus(), batchMasterDTO.getFileName(),
						batchMasterDTO.getTotalCases(), batchMasterDTO.getPid(),

						batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(),
						batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(),
						batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(),
						batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(),
						batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(),
						batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(), batchMasterDTO.getColumnSort(),

						batchMasterDTO.getLength(), batchMasterDTO.getStart() },
				new BeanPropertyRowMapper<BatchMaster>(BatchMaster.class));

		return list;
	}

	// Save BATCH MASTER
	@Override
	public long saveBatchMasterAll(BatchMasterDTO batchMasterDTO) {

		String query = env.getProperty(BatchMasterConstant.BATCH_MASTER_SAVE);

		GeneratedKeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] { BatchMasterConstant.ID });

			if (batchMasterDTO.getBatchType() != null) {
				ps.setString(1, batchMasterDTO.getBatchType().toUpperCase());
			} else {
				ps.setNull(1, Types.VARCHAR);
			}
			if (batchMasterDTO.getCount() != null) {
				ps.setString(2, batchMasterDTO.getCount());
			} else {
				ps.setNull(2, Types.VARCHAR);
			}
			if (batchMasterDTO.getOperatorId() != null) {
				ps.setString(3, batchMasterDTO.getOperatorId());
			} else {
				ps.setNull(3, Types.VARCHAR);
			}

			if (batchMasterDTO.getBatchNumber() != null) {
				ps.setString(4, batchMasterDTO.getBatchNumber());
			} else {
				ps.setNull(4, Types.VARCHAR);
			}

//			if (batchMasterDTO.getStatus() != null) {
//				ps.setString(5, batchMasterDTO.getStatus().toUpperCase());
//			} else {
//				ps.setNull(5, Types.VARCHAR);
//			}
//
//			if (batchMasterDTO.getStartDate() != null) {
//				ps.setDate(6, (Date) batchMasterDTO.getStartDate());
//			} else {
//				ps.setNull(6, Types.DATE);
//			}
//
//			if (batchMasterDTO.getEndDate() != null) {
//				ps.setDate(7, (Date) batchMasterDTO.getEndDate());
//			} else {
//				ps.setNull(7, Types.DATE);
//			}
//
//			if (batchMasterDTO.getCreatedBy() != null) {
//				ps.setLong(8, batchMasterDTO.getCreatedBy());
//			} else {
//				ps.setNull(8, Types.INTEGER);
//			}
//
//			if (batchMasterDTO.getLastUpdateLogin() != null) {
//				ps.setLong(9, batchMasterDTO.getLastUpdateLogin());
//			} else {
//				ps.setNull(9, Types.INTEGER);
//			}
//
//			if (batchMasterDTO.getLastUpdatedBy() != null) {
//				ps.setLong(10, batchMasterDTO.getLastUpdatedBy());
//			} else {
//				ps.setNull(10, Types.INTEGER);
//			}
//
//			if (batchMasterDTO.getLastUpdateDate() != null) {
//				ps.setDate(11, (Date) batchMasterDTO.getLastUpdateDate());
//			} else {
//				ps.setNull(11, Types.DATE);
//			}
			return ps;
		}, holder);

		BigDecimal bigDecimal = (BigDecimal) holder.getKey();
		assert bigDecimal != null;

		return bigDecimal.longValue();

	}

	// UPDATE BATCH MASTER
	@Override
	public void updateBatchMasterAll(Long batchId, BatchMasterDTO batchMasterDTO) {

		String query = env.getProperty(BatchMasterConstant.BATCH_MASTER_UPDATE);
//		 assert query != null;

		batchMasterDTO.setCmsBatchMastId(batchId);

		try {
			jdbcTemplate.update(query,

					batchMasterDTO.getStatus(), batchMasterDTO.getCreatedBy(), batchMasterDTO.getLastUpdateLogin(),
					batchMasterDTO.getLastUpdatedBy(), batchMasterDTO.getCmsBatchMastId()

			);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateZipAndCasesAll(UpdateZipCasesDTO updateZipCasesDTO) {

		String query = env.getProperty(BatchMasterConstant.UPDATE_ZIP_AND_CASES);
		try {
			jdbcTemplate.update(query, updateZipCasesDTO.getFileName(), updateZipCasesDTO.getTotalCases(),
					updateZipCasesDTO.getCmsBatchMastId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
