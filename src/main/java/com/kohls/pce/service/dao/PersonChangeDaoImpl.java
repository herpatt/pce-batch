package com.kohls.pce.service.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kohls.pce.model.PriceChange;

@Repository
public class PersonChangeDaoImpl implements PersonChangeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<PriceChange> findAllPCE(BigInteger startPageNumber,BigInteger pageSize,PriceChange priceChange) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return namedParameterJdbcTemplate.query("",paramMap, new PriceChangeMapper());
	}

	@Override
	public boolean updatePCE(List<PriceChange> priceChangeList) {
		for( PriceChange priceChange :  priceChangeList ) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("eventCode", priceChange.getEventCategoryCode());
			namedParameterJdbcTemplate.update("", paramMap);			
		}
		return true;
	}

	class PriceChangeMapper implements RowMapper {
		@Override
		public PriceChange mapRow(ResultSet rs, int rowNum) throws SQLException {
			PriceChange priceChange = new PriceChange();
			return priceChange;
		}
	}
}
