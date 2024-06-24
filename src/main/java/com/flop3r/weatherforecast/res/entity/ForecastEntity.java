package com.flop3r.weatherforecast.res.entity;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ForecastEntity represents the forecast details, encapsulating an array of
 * daily weather forecasts.
 *
 * Fields:
 * - forecastDay (WeatherForecastEntity[]): An array of WeatherForecastEntity objects
 *   containing daily weather forecast parameters.
 *
 * Note:
 * ForecastEntity is designed to store a list of WeatherForecastEntity objects and
 * is extendable for future features (e.g. air quality forecasts).
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastEntity {

    @JsonProperty("forecastday")
    private WeatherForecastEntity[] forecastDay;

    //...
}
