package com.kohls.pce.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DbConfig.class,BatchConfiguration.class})
public class PceBatchApplication implements CommandLineRunner {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("priceChangeJob")
	Job priceChangeJob;
	
	@Autowired
	@Qualifier("deleteJob")
	Job deleteJob;	
	
	@Autowired
	@Qualifier("priceChangeReaderWriterJob")
	Job priceChangeReaderWriterJob;		

	public static void main(String[] args) {
		SpringApplication.run(PceBatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();
		//jobLauncher.run(priceChangeJob, params);
		
		jobLauncher.run(priceChangeReaderWriterJob, params);
	}
}