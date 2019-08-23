package com.framework.Tct.batchService;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration{
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	@Qualifier("primaryDataSource")
	public DataSource primaryDataSource;
	
	@Bean
	public FlatFileItemReader<User2> reader(){
		FlatFileItemReader<User2> reader = new FlatFileItemReader<User2>();
		reader.setResource(new ClassPathResource("file.csv"));
		reader.setLineMapper(new DefaultLineMapper<User2>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] {
								"firstName","lastName"
						});
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<User2>() {
					{
						setTargetType(User2.class);
					}
				});
			}
			
		});
		return reader;
		
	}
	@Bean
	public User2ItemProcessor processor() {
		return new User2ItemProcessor();
	}
	@Bean
	public JdbcBatchItemWriter<User2> writer(){
		JdbcBatchItemWriter<User2> writer = new JdbcBatchItemWriter<User2>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User2>());
		writer.setSql("Insert INTO USERS2 (first_name, last_name) VALUES (:firstName, :lastName)");
		writer.setDataSource(primaryDataSource);
		return writer;
	}
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory
				.get("importUserJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1())
				.end()
				.build();
	}
	@Bean
	public Step step1() {
		// TODO Auto-generated method stub
		return stepBuilderFactory.get("step1")
				.<User2,User2>chunk(10)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	

}
