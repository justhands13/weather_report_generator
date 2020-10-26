package com.example.weather.weather_report_generator.reader;

import com.example.weather.weather_report_generator.models.City;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.core.io.ClassPathResource;

public class WeatherJsonReader {
    static private int chunk =0;
    public FlatFileItemReader<City> read() {

        System.out.println("inside reader: "+ chunk++);

        return new FlatFileItemReaderBuilder<City>()
                .name("CityItemReader")
                .resource(new ClassPathResource("cities.txt"))
                .delimited()
                .names(new String[] {"name"})
                .targetType(City.class)
                .build();
    }

}
