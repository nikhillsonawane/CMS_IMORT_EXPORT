package com.cms.importexport.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cms.importexport.constant.NsdlMasterExportConstant;
import com.cms.importexport.dto.NsdlMasterExportDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@PropertySource(value = "classpath:queries/nsdlMasterExportQuerries.properties", ignoreResourceNotFound = true)
public class NsdlMasterExportImpl implements NsdlMasterExport {

	private final JdbcTemplate jdbcTemplate;
	private final Environment env;

	@Override
	public List<NsdlMasterExportDTO> getNsdlMasterExport() {
		List<NsdlMasterExportDTO> nsdlMasterExportDTOList = new ArrayList<NsdlMasterExportDTO>();

		try {
			String query = env.getProperty(NsdlMasterExportConstant.GET_NSDL_MASTER);
			nsdlMasterExportDTOList = jdbcTemplate.query(query, new Object[] {},
					new BeanPropertyRowMapper<NsdlMasterExportDTO>(NsdlMasterExportDTO.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("nsdl =" + nsdlMasterExportDTOList);
		return nsdlMasterExportDTOList;
	}

}
