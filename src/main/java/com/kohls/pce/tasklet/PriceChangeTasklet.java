package com.kohls.pce.tasklet;

import java.math.BigInteger;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.kohls.pce.model.PriceChange;
import com.kohls.pce.service.PersonChangeService;

public class PriceChangeTasklet implements Tasklet {

	@Autowired
	PersonChangeService personChangeService;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		BigInteger startPageNumber = BigInteger.ZERO;
		BigInteger pageSize = BigInteger.valueOf(2);
		List<PriceChange> priceChangeList = null;
		do {
			priceChangeList = personChangeService.findAllPCE(startPageNumber, pageSize, null);
			personChangeService.updatePCE(priceChangeList);
			startPageNumber.add(pageSize);
		} while(priceChangeList != null);
		return RepeatStatus.FINISHED;
	}
}