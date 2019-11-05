package com.kohls.pce.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kohls.pce.model.PriceChange;
import com.kohls.pce.service.dao.PersonChangeDao;

@Service
@Transactional
public class PersonChangeServiceImpl implements PersonChangeService {

	@Autowired
	PersonChangeDao personChangeDao;
	
	@Override
	public boolean updatePCE(List<PriceChange> priceChangeList) {
		return personChangeDao.updatePCE(priceChangeList);
	}

	@Override
	public List<PriceChange> findAllPCE(BigInteger startPageNumber,BigInteger pageSize,PriceChange priceChange) {
		return personChangeDao.findAllPCE(startPageNumber,pageSize,priceChange);
	}

	@Override
	public boolean loadPriceChange() {
		return personChangeDao.loadPriceChange();
	}

}
