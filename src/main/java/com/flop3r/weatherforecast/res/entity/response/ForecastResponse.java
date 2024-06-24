package com.flop3r.weatherforecast.res.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flop3r.weatherforecast.res.entity.LocationEntity;
import com.flop3r.weatherforecast.res.entity.WeatherForecastEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * ForecastResponse is a Data Transfer Object (DTO) that represents the payload
 * sent by our app in response to a GET request to the endpoint /api/v1/forecast.
 *
 * This class contains information about the location for which the forecast is provided,
 * as well as an array of weather forecast details for the specified period.
 *
 * Fields:
 * - location (LocationEntity): Represents the geographical location details.
 * - weatherForecasts (WeatherForecastEntity[]): An array of WeatherForecastEntity objects
 *   containing daily weather forecast parameters.
 *
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

    @JsonProperty("location")
    private LocationEntity location;

    /* WeatherForecastEntity stores only daily weather forecast parameters.
     *
     * ForecastEntity can store a list of WeatherForecastEntity objects and
     * is designed to be extendable for future features.
     */
    @JsonProperty("forecast")
    private WeatherForecastEntity[] weatherForecasts;
}
