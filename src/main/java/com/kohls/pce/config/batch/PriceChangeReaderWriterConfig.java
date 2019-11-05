package com.kohls.pce.config.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kohls.pce.batch.events.PriceChangeProcessor;
import com.kohls.pce.batch.events.PriceChangeReader;
import com.kohls.pce.batch.events.PriceChangeWriter;
import com.kohls.pce.model.PriceChange;

@Configuration
@EnableBatchProcessing
public class PriceChangeReaderWriterConfig {

    @Autowired 
    private JobBuilderFactory jobs;

    @Autowired 
    private StepBuilderFactory steps;
    
    @Autowired
    DataSource dataSource;
    
    @Bean
    public ItemReader<PriceChange> priceChangeReader(){
    	PriceChangeReader priceChangeReader = new PriceChangeReader();
    	return priceChangeReader.priceChangeReader(dataSource);
    };
    
    @Bean
    public ItemProcessor<PriceChange, PriceChange> priceChangeProcessor() {
        return new PriceChangeProcessor();
    }

    @Bean
    public ItemWriter<PriceChange> priceChangeWriter() {
        return new PriceChangeWriter();
    }

    @Bean
    protected Step processStep() {
        return steps.get("priceChangeReaderWriterStep").<PriceChange, PriceChange> chunk(25)
          .reader(priceChangeReader())
          .processor(priceChangeProcessor())
          .writer(priceChangeWriter())
          .build();
    }

    @Bean
    public Job priceChangeReaderWriterJob() {
        return jobs
          .get("priceChangeReaderWriterJob")
          .start(processStep())
          .build();
    }
}