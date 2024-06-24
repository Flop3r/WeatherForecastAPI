package com.flop3r.weatherforecast.entity;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WeatherHourlyEntity represents the hourly weather details.
 *
 * Fields:
 * - time (String): The time of the forecast.
 * - windspeed (Float): The wind speed in kilometers per hour.
 *
 * Note:
 * This class is designed to be extendable for future features and additional
 * weather parameters.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherHourlyEntity {

    @JsonProperty("time")
    private String time;

    @JsonProperty("wind_kph")
    private Float windspeed;
}
