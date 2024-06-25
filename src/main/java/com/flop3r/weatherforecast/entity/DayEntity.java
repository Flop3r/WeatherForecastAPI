package com.flop3r.weatherforecast.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "day")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DayEntity {
    @JsonProperty("date")
    private String date;

    @JsonProperty("day")
    private WeatherDayEntity day;

    @JsonProperty("hour")
    private WeatherHourEntity[] hour;

}
