package com.example.weatherforecast.res.entity.response;

import lombok.Getter;
import lombok.Setter;

import com.example.weatherforecast.res.entity.ForecastEntity;
import com.example.weatherforecast.res.entity.LocationEntity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ForecastResponse is a data transfer object (DTO) representing the response
 * received from an external weather forecast API.
 *
 * This class encapsulates the forecast information for a specific location,
 * including an array of weather forecast details for a given period.
 *
 * Fields:
 * - location (LocationEntity): Details about the geographical location.
 * - forecast (ForecastEntity): Contains a list of WeatherForecastEntity objects
 *   and is designed to be extendable for future features.
 */

@Getter
@Setter
public class WeatherApiResponse {

    @JsonProperty("location")
    private LocationEntity location;

    /* WeatherForecastEntity stores only daily weather forecast parameters.
     *
     * ForecastEntity can store a list of WeatherForecastEntity objects and
     * is designed to be extendable for future features.
     */
    @JsonProperty("forecast")
    private ForecastEntity forecast;
}
