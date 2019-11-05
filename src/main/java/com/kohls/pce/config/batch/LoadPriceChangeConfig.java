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

import com.kohls.pce.tasklet.LoadPriceChangeTasklet;

@Configuration
@EnableBatchProcessing
public class LoadPriceChangeConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	LoadPriceChangeTasklet loadPriceChangeTasklet;
	
	@Bean
	public Step loadPriceChangeTaskletStep() {
		return steps.get("loadPriceChangeJobStep").tasklet(loadPriceChangeTasklet).build();
	}

	@Bean("loadPriceChangeJob")
	public Job loadPriceChangeJob() {
		return jobs.get("loadPriceChangeJob").incrementer(new RunIdIncrementer()).start(loadPriceChangeTaskletStep()).build();
	}
}