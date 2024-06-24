package com.flop3r.weatherforecast.res.domain.forecast;

import lombok.Builder;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Builder
public class WeatherDaily {

    @JsonProperty("max_temp")
    private Float maxTemperature;

    @JsonProperty("min_temp")
    private Float minTemperature;

    @JsonProperty("avg_temp")
    private Float avgTemperature;

    @JsonProperty("total_rain")
    private Float totalRain;

    @JsonProperty("total_snow")
    private Float totalSnow;

    @JsonProperty("avg")
    private Float avgHumidity;
    private Float avgVisibility;
    private Integer uv;
}
