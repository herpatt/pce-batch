package com.kohls.pce.batch.events;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.kohls.pce.model.PriceChange;
import com.kohls.pce.service.PersonChangeService;

public class PriceChangeWriter implements ItemWriter<PriceChange> {

	@Autowired
	PersonChangeService personChangeService;

	@Override
	public void write(List<? extends PriceChange> priceChangeList) throws Exception {
		System.out.println("\n\n\n\n--------------------------------------------------------------");
		System.out.println("PriceChangeWriter :: write :: called::"+priceChangeList);
		System.out.println("--------------------------------------------------------------\n\n\n\n");
		//personChangeService.updatePCE((List<PriceChange>) priceChangeList);
	}
}