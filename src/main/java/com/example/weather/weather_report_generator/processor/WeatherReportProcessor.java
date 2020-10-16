package com.example.weather.weather_report_generator.processor;

import com.example.weather.weather_report_generator.models.BriefWeatherReport;
import com.example.weather.weather_report_generator.models.FullWeatherReport;
import org.springframework.batch.item.ItemProcessor;

public class WeatherReportProcessor implements ItemProcessor<FullWeatherReport, BriefWeatherReport> {
    @Override
    public BriefWeatherReport process(FullWeatherReport fullWeatherReport) throws Exception {
        BriefWeatherReport briefWeatherReport = new BriefWeatherReport();

        briefWeatherReport.setId(fullWeatherReport.getId());
        briefWeatherReport.setName(fullWeatherReport.getName());
        briefWeatherReport.setDt(fullWeatherReport.getDt());
        briefWeatherReport.setWeather(fullWeatherReport.getWeather()[0].getMain());
        briefWeatherReport.setTemp(fullWeatherReport.getMain().getTemp());
        briefWeatherReport.setHumidity(fullWeatherReport.getMain().getHumidity());
        briefWeatherReport.setWind(fullWeatherReport.getWind().getSpeed());

        return briefWeatherReport;
    }
}
