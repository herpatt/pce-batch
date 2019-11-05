package com.kohls.pce.service;

import java.math.BigInteger;
import java.util.List;

import com.kohls.pce.model.PriceChange;

public interface PersonChangeService {
	
	boolean updatePCE(List<PriceChange> priceChangeList);

	List<PriceChange> findAllPCE(BigInteger startPageNumber,BigInteger pageSize,PriceChange priceChange);
	
	public boolean loadPriceChange();
}
