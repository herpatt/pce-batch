package com.kohls.pce.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
@ComponentScan(basePackages = {"com.kohls.pce.tasklet","com.kohls.pce.service","com.kohls.pce.dao"})
public class BatchConfiguration {

	@Autowired
	//@Qualifier("pceTransactionManager")
	PlatformTransactionManager transactionManager;
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTransactionManager(transactionManager);
		factory.afterPropertiesSet();
		return (JobRepository) factory.getObject();
	}

	@Bean
	public JobLauncher getJobLauncher() throws Exception  {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		try {
			jobLauncher.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobLauncher;
	}

}