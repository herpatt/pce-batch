package com.kohls.pce.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kohls.pce.service.PersonChangeService;

@Component
public class LoadPriceChangeTasklet implements Tasklet {

	@Autowired
	PersonChangeService personChangeService;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		personChangeService.loadPriceChange();
		return RepeatStatus.FINISHED;
	}
}