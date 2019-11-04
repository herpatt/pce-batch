package com.kohls.pce.batch.events;

import org.springframework.batch.item.ItemProcessor;

import com.kohls.pce.model.PriceChange;

public class PriceChangeProcessor implements ItemProcessor<PriceChange, PriceChange>  {
	
    @Override
    public PriceChange process(PriceChange priceChange) throws Exception {
        System.out.println("PriceChangeProcessor :: process :: called");
    	return priceChange;
    }
 }