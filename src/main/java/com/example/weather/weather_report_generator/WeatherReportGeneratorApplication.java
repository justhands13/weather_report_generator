package com.example.weather.weather_report_generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherReportGeneratorApplication {

	public static void main(String[] args) {
		System.out.println("Program started...");
		SpringApplication.run(WeatherReportGeneratorApplication.class, args);
	}

}
