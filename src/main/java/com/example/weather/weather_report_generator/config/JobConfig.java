package com.example.weather.weather_report_generator.config;

import com.example.weather.weather_report_generator.models.BriefWeatherReport;
import com.example.weather.weather_report_generator.models.City;
import com.example.weather.weather_report_generator.processor.WeatherReportProcessor;
import com.example.weather.weather_report_generator.reader.WeatherJsonReader;
import com.example.weather.weather_report_generator.writer.CityWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class JobConfig {
    @Bean
    public Job retrieveWeatherJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory){
        return jobBuilderFactory.get("weatherSiteToDB")
                .start(stepSiteToDB(stepBuilderFactory))
                .build();
    }

    @Bean
    public Step stepSiteToDB(StepBuilderFactory stepBuilderFactory){
        return stepBuilderFactory.get("weatherJsonToDB")
                .<City, BriefWeatherReport>chunk(5)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }

    @Bean
    public FlatFileItemReader<City> itemReader(){
        WeatherJsonReader weatherJsonReader = new WeatherJsonReader();
        return weatherJsonReader.read();
    }

    @Bean
    public WeatherReportProcessor itemProcessor() {
        return new WeatherReportProcessor();
    }

    @Bean
    public CityWriter itemWriter(){
        return new CityWriter();
    }

}

