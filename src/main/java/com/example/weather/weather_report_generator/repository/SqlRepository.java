package com.example.weather.weather_report_generator.repository;

import com.example.weather.weather_report_generator.models.BriefWeatherReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlRepository extends JpaRepository<BriefWeatherReport,Integer> {
}
