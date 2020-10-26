package com.example.weather.weather_report_generator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullWeatherReport {
    private int cod, id, timezone, dt;
    private String name, base;
    private double visibility;

    private Coordinates coordinates;
    private Weather[] weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private System system;
}
