package com.kohls.pce.service.dao;

import java.math.BigInteger;
import java.util.List;

import com.kohls.pce.model.PriceChange;

public interface PersonChangeDao {

	boolean updatePCE(List<PriceChange> priceChangeList);

	List<PriceChange> findAllPCE(BigInteger startPageNumber,BigInteger pageSize,PriceChange priceChange);
}