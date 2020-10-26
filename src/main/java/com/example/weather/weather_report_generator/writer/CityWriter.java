package com.example.weather.weather_report_generator.writer;

import com.example.weather.weather_report_generator.models.BriefWeatherReport;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public class CityWriter implements ItemWriter<BriefWeatherReport> {

    @Autowired
    JpaRepository jpaRepository;

    @Override
    public void write(List<? extends BriefWeatherReport> list) throws Exception {

        jpaRepository.saveAll(list);

    }
}
