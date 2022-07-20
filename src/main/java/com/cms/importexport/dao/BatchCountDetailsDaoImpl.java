package com.cms.importexport.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Types;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.BatchCountDetailsConstant;
import com.cms.importexport.dto.BatchCountDetailsDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/BatchCountDetails.properties", ignoreResourceNotFound = true)
public class BatchCountDetailsDaoImpl implements BatchCountDetailsDao {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;
	GeneratedKeyHolder holder = new GeneratedKeyHolder();

	@Override
	public long saveBatchCountDetailsServiceAll(BatchCountDetailsDTO batchCountDetailsDTO) {

		String query = env.getProperty(BatchCountDetailsConstant.SAVE_BATCH_COUNT_DETAILS);
		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] { BatchCountDetailsConstant.ID });

			if (batchCountDetailsDTO.getCmsBatchMastId() != null) {
				ps.setLong(1, batchCountDetailsDTO.getCmsBatchMastId());
			} else {
				ps.setNull(1, Types.INTEGER);
			}
			if (batchCountDetailsDTO.getFileName() != null) {
				ps.setString(2, batchCountDetailsDTO.getFileName());
			} else {
				ps.setNull(2, Types.VARCHAR);
			}
			if (batchCountDetailsDTO.getRecordCount() != null) {
				ps.setLong(3, batchCountDetailsDTO.getRecordCount());
			} else {
				ps.setNull(3, Types.INTEGER);
			}
			if (batchCountDetailsDTO.getStatus() != null) {
				ps.setString(4, batchCountDetailsDTO.getStatus());
			} else {
				ps.setNull(4, Types.VARCHAR);
			}
			if (batchCountDetailsDTO.getCreatedBy() != null) {
				ps.setLong(5, batchCountDetailsDTO.getCreatedBy());
			} else {
				ps.setNull(5, Types.INTEGER);
			}
			if (batchCountDetailsDTO.getLastUpdateLogin() != null) {
				ps.setLong(6, batchCountDetailsDTO.getLastUpdateLogin());
			} else {
				ps.setNull(6, Types.INTEGER);
			}
			if (batchCountDetailsDTO.getLastUpdatedBy() != null) {
				ps.setLong(7, batchCountDetailsDTO.getLastUpdatedBy());
			} else {
				ps.setNull(7, Types.INTEGER);
			}
			return ps;
		}, holder);

		BigDecimal bigDecimal = (BigDecimal) holder.getKey();
		assert bigDecimal != null;
		return bigDecimal.longValue();
	}
}
