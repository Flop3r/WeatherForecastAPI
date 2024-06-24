package com.flop3r.weatherforecast.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * WeatherDailyEntity represents the daily weather details.
 *
 * Fields:
 * - maxTemperature (Float): The maximum temperature in Celsius.
 * - minTemperature (Float): The minimum temperature in Celsius.
 * - avgTemperature (Float): The average temperature in Celsius.
 * - totalRain (Float): The total precipitation in millimeters.
 * - totalSnow (Float): The total snowfall in centimeters.
 * - avgHumidity (Float): The average humidity percentage.
 * - avgVisibility (Float): The average visibility in kilometers.
 * - uv (Integer): The UV index.
 */
@Getter
@Setter
@Schema(name = "weather-day")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDayEntity {

    @JsonProperty("maxtemp_c")
    private Float maxTemperature;

    @JsonProperty("mintemp_c")
    private Float minTemperature;

    @JsonProperty("avgtemp_c")
    private Float avgTemperature;

    @JsonProperty("totalprecip_mm")
    private Float totalRain;

    @JsonProperty("totalsnow_cm")
    private Float totalSnow;

    @JsonProperty("avghumidity")
    private Float avgHumidity;

    @JsonProperty("avgvis_km")
    private Float avgVisibility;

    @JsonProperty("uv")
    private Integer uv;
}
