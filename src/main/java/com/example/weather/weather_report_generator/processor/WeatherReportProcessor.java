package com.example.weather.weather_report_generator.processor;

import com.example.weather.weather_report_generator.models.BriefWeatherReport;
import com.example.weather.weather_report_generator.models.City;
import com.example.weather.weather_report_generator.models.FullWeatherReport;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class WeatherReportProcessor implements ItemProcessor<City, BriefWeatherReport> {
    @Override
    public BriefWeatherReport process(City city){

        FullWeatherReport fullWeatherReport = getFullWeatherReport(city.getName());

        return extractBriefWeatherReport(fullWeatherReport);

    }

    public FullWeatherReport getFullWeatherReport(String city){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                    "http://api.openweathermap.org/data/2.5/weather?q=" +
                         city +
                        "&appid=65f0c977c0e99d4dfc81cbcfa0e58916"
                , FullWeatherReport.class);
    }

    public BriefWeatherReport extractBriefWeatherReport(FullWeatherReport fullWeatherReport){
        BriefWeatherReport briefWeatherReport = new BriefWeatherReport();
        briefWeatherReport.setId(fullWeatherReport.getId());
        briefWeatherReport.setName(fullWeatherReport.getName());
        briefWeatherReport.setDate(getDate(fullWeatherReport.getDt()));
        briefWeatherReport.setWeather(fullWeatherReport.getWeather()[0].getMain());
        briefWeatherReport.setTemp(fullWeatherReport.getMain().getTemp());
        briefWeatherReport.setHumidity(fullWeatherReport.getMain().getHumidity());
        briefWeatherReport.setWind(fullWeatherReport.getWind().getSpeed());
        return briefWeatherReport;
    }

    private String getDate(int timestamp){
        Instant instant = Instant.ofEpochSecond(timestamp);
        Date date = Date.from(instant);
        String pattern = "EEE, d MMM yyyy HH:mm:ss Z";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }
}