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
		return namedParameterJdbcTemplate.query("SELECT * from tablename order by f1,f2 limit :pageSize, :pageCount",paramMap, new PriceChangeMapper());
	}

	@Override
	public boolean updatePCE(List<PriceChange> priceChangeList) {
		if( priceChangeList != null ) {
			for( PriceChange priceChange :  priceChangeList ) {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("eventCode", priceChange.getEventCategoryCode());
				namedParameterJdbcTemplate.update("UPDATE QUERY", paramMap);			
			}			
		}
		return true;
	}
	
	//CREATE TABLE `pxtw_evnt_str_mdse` (`evnt_cde` varchar(100) NOT NULL,`str_nbr` varchar(100) NOT NULL,`sku_nbr` varchar(100) NOT NULL);
	
	@Override
	public boolean loadPriceChange() {
		for (int i = 0; i <= 100; i++) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("evnt_cde", "EVNT" + i);
			paramMap.put("str_nbr", "STRT" + i);
			paramMap.put("sku_nbr", "SKU" + i);
			namedParameterJdbcTemplate.update(
					"INSERT INTO pxtw_evnt_str_mdse(evnt_cde, str_nbr, sku_nbr) VALUES (:evnt_cde, :str_nbr, :sku_nbr); ",
					paramMap);
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
