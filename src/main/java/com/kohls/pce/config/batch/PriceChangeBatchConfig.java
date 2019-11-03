package com.kohls.pce.config.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kohls.pce.tasklet.PriceChangeTasklet;

@Configuration
@EnableBatchProcessing
public class PriceChangeBatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;
	
	@Autowired
	PriceChangeTasklet priceChangeTasklet;

	@Bean
	public Step priceChangeStep() {
		return steps.get("priceChangeStep").tasklet(priceChangeTasklet).build();
	}

	@Bean("priceChangeJob")
	public Job priceChangeJob() {
		return jobs.get("priceChangeJob").incrementer(new RunIdIncrementer()).start(priceChangeStep()).build();
	}
}