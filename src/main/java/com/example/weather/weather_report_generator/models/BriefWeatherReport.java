package com.example.weather.weather_report_generator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "brief_weather_report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BriefWeatherReport {
    @Id
    private int id;
//    private int dt;
//    private java.sql.Date da;
    private String date, name, weather;
    private double temp, humidity, wind;
}
