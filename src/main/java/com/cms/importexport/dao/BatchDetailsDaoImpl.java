package com.cms.importexport.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.Types;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.BatchDetailsConstant;
import com.cms.importexport.dto.BatchDetailsDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/batchDetailsQueries.properties", ignoreResourceNotFound = true)
public class BatchDetailsDaoImpl implements BatchDetailsDao {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;

	@Override
	public long saveBatchDetailsAll(BatchDetailsDTO batchDetailsDTO) {

		String query = env.getProperty(BatchDetailsConstant.SAVE_BATCH_DETAILS);
		GeneratedKeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(query, new String[] { BatchDetailsConstant.ID });

			if (batchDetailsDTO.getTradingBatchMastId() != null) {
				ps.setLong(1, batchDetailsDTO.getTradingBatchMastId());
			} else {
				ps.setNull(1, Types.INTEGER);
			}
			if (batchDetailsDTO.getBarcode() != null) {
				ps.setString(2, batchDetailsDTO.getBarcode());
			} else {
				ps.setNull(2, Types.VARCHAR);
			}
			if (batchDetailsDTO.getFileName() != null) {
				ps.setString(3, batchDetailsDTO.getFileName());
			} else {
				ps.setNull(3, Types.VARCHAR);
			}
			if (batchDetailsDTO.getCmsCheckerId() != null) {
				ps.setLong(4, batchDetailsDTO.getCmsCheckerId());
			} else {
				ps.setNull(4, Types.INTEGER);
			}

			return ps;
		}, holder);

		BigDecimal bigDecimal = (BigDecimal) holder.getKey();
		assert bigDecimal != null;
		return bigDecimal.longValue();
	}

	@Override
	public void updateCloserDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO) {

		String query = env.getProperty(BatchDetailsConstant.UPDATE_CLOSER_DETAILS);
		batchDetailsDTO.setCmsCheckerId(checkerId);

		try {
			jdbcTemplate.update(query, batchDetailsDTO.getAccountCloserId(), batchDetailsDTO.getCloserDpId(),
					batchDetailsDTO.getCloserDpHolding(), batchDetailsDTO.getCloserTargetDepository(),
					batchDetailsDTO.getCloserTargetDpId(), batchDetailsDTO.getCloserTargetClientId(),
					batchDetailsDTO.getCloserPanNo(), batchDetailsDTO.getCmsCheckerId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCorresDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO) {
		String query = env.getProperty(BatchDetailsConstant.UPDATE_CORRES_DETAILS);
		batchDetailsDTO.setCmsCheckerId(checkerId);

		try {
			jdbcTemplate.update(query, batchDetailsDTO.getAddressCorresId(), batchDetailsDTO.getAccountType(),
					batchDetailsDTO.getCorresAdd1(), batchDetailsDTO.getCorresAdd2(), batchDetailsDTO.getCorresAdd3(),
					batchDetailsDTO.getCorresCountryId(), batchDetailsDTO.getCorresStateId(),
					batchDetailsDTO.getCorresCityId(), batchDetailsDTO.getCorresZipId(),
					batchDetailsDTO.getCorresUserRemarks(), batchDetailsDTO.getCmsCheckerId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePermDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO) {

		String query = env.getProperty(BatchDetailsConstant.UPDATE_PERM_DETAILS);
		batchDetailsDTO.setCmsCheckerId(checkerId);
		try {
			jdbcTemplate.update(query,

					batchDetailsDTO.getAddressPermId(), batchDetailsDTO.getPermAccountType(),
					batchDetailsDTO.getPermAdd1(), batchDetailsDTO.getPermAdd2(), batchDetailsDTO.getPermAdd3(),
					batchDetailsDTO.getPermCountryId(), batchDetailsDTO.getPermStateId(),
					batchDetailsDTO.getPermCityId(), batchDetailsDTO.getPermZipId(),
					batchDetailsDTO.getPermUserRemarks(), batchDetailsDTO.getCmsCheckerId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// update Bank Details
	@Override
	public void updateBankDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO) {

		String query = env.getProperty(BatchDetailsConstant.UPDATE_BANK_DETAILS);
		batchDetailsDTO.setCmsCheckerId(checkerId);
		try {
			jdbcTemplate.update(query, batchDetailsDTO.getBankId(), batchDetailsDTO.getAccountType(),
					batchDetailsDTO.getBankName(), batchDetailsDTO.getBankIfscCode(), batchDetailsDTO.getBankCode(),
					batchDetailsDTO.getBankAccountType(), batchDetailsDTO.getBankAccountNo(),
					batchDetailsDTO.getBankAddress1(), batchDetailsDTO.getBankAddress2(), batchDetailsDTO.getBankCity(),
					batchDetailsDTO.getBankPincode(), batchDetailsDTO.getBankMicrCode(),
					batchDetailsDTO.getBankAccountCurrency(), batchDetailsDTO.getCmsCheckerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateContactDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO) {

		String query = env.getProperty(BatchDetailsConstant.UPDATE_CONTACT_DETAILS);
		batchDetailsDTO.setCmsCheckerId(checkerId);

		try {
			jdbcTemplate.update(query,

					batchDetailsDTO.getContactDetailsId(), batchDetailsDTO.getContactAccountType(),
					batchDetailsDTO.getEmailIdFirstHolder(), batchDetailsDTO.getFfFhForEmailId(),
					batchDetailsDTO.getFhIsdCodeForMobileNo(), batchDetailsDTO.getFhOfMobileNo(),
					batchDetailsDTO.getFhFfForMobileNo(), batchDetailsDTO.getShEmailId(),
					batchDetailsDTO.getShFfForEmailId(), batchDetailsDTO.getShIsdCodeForMobileNo(),
					batchDetailsDTO.getShOfMobileNo(), batchDetailsDTO.getShFfForMobileNo(),
					batchDetailsDTO.getThEmailId(), batchDetailsDTO.getThFfForEmailId(),
					batchDetailsDTO.getThIsdCodeForMobileNo(), batchDetailsDTO.getThOfMobileNo(),
					batchDetailsDTO.getThFfForMobileNo(), batchDetailsDTO.getCmsCheckerId()

			);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateIncomeDetailsAll(Long checkerId, BatchDetailsDTO batchDetailsDTO) {

		String query = env.getProperty(BatchDetailsConstant.UPDATE_INCOME_DETAILS);
		batchDetailsDTO.setCmsCheckerId(checkerId);

		try {
			jdbcTemplate.update(query,

					batchDetailsDTO.getCheckerIncomeRangeId(), batchDetailsDTO.getIncomeType(),
					batchDetailsDTO.getIncomeRange(), batchDetailsDTO.getIncomeRangeId(),
					batchDetailsDTO.getCmsCheckerId());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
