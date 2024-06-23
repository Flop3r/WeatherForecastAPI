package com.example.weatherforecast.res.entity;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherForecastEntity represents daily weather forecast details.
 *
 * This class focuses solely on weather-related data.
 *
 * Fields:
 * - date (String): The date of the forecast.
 * - day (WeatherDailyEntity): The daily weather details.
 * - hour (WeatherHourlyEntity[]): An array of hourly weather details.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastEntity {
    @JsonProperty("date")
    private String date;

    @JsonProperty("day")
    private WeatherDailyEntity day;

    @JsonProperty("hour")
    private WeatherHourlyEntity[] hour;

}
