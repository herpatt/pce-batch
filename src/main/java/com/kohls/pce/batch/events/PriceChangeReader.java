package com.kohls.pce.batch.events;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.kohls.pce.model.PriceChange;

public class PriceChangeReader {

	public ItemReader<PriceChange> priceChangeReader(DataSource dataSource) {
		
		JdbcPagingItemReader<PriceChange> priceChangeReader = new JdbcPagingItemReader<>();

		priceChangeReader.setDataSource(dataSource);
		priceChangeReader.setPageSize(2);

		PagingQueryProvider queryProvider = createQueryProvider();
		priceChangeReader.setQueryProvider(queryProvider);

		priceChangeReader.setRowMapper(new BeanPropertyRowMapper<>(PriceChange.class));

		return priceChangeReader;
	}

	private PagingQueryProvider createQueryProvider() {
		MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();

		queryProvider.setSelectClause("SELECT evnt_cde, str_nbr,sku_nbr");
		queryProvider.setFromClause("FROM pxtw_evnt_str_mdse");
		queryProvider.setSortKeys(sortByEmailAddressAsc());

		return queryProvider;
	}

	private Map<String, Order> sortByEmailAddressAsc() {
		Map<String, Order> sortConfiguration = new HashMap<>();
		sortConfiguration.put("evnt_cde", Order.ASCENDING);
		sortConfiguration.put("str_nbr", Order.ASCENDING);
		sortConfiguration.put("sku_nbr", Order.ASCENDING);
		return sortConfiguration;
	}
}