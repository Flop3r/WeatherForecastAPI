package com.flop3r.weatherforecast.res.entity.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.flop3r.weatherforecast.res.entity.ForecastEntity;
import com.flop3r.weatherforecast.res.entity.LocationEntity;
import lombok.Getter;
import lombok.Setter;

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
public class WeatherDataResponse {

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
