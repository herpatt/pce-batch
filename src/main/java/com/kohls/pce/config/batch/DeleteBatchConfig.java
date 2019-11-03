package com.kohls.pce.config.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kohls.pce.tasklet.DeleteTasklet;

@Configuration
public class DeleteBatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Autowired
	DeleteTasklet deleteTasklet;
	
	@Bean
	public Step deleteTaskletStep() {
		return steps.get("deleteJobStep").tasklet(deleteTasklet).build();
	}

	@Bean("deleteJob")
	public Job deleteJob() {
		return jobs.get("deleteJob").incrementer(new RunIdIncrementer()).start(deleteTaskletStep()).build();
	}
}