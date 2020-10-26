package com.example.weather.weather_report_generator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    private double temp, feels_like, temp_min, temp_max, humidity, pressure;


}
