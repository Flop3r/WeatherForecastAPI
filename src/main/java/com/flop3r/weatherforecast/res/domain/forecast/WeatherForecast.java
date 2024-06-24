package com.flop3r.weatherforecast.res.domain.forecast;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WeatherForecast {

    private LocalDate date;
    private WeatherDaily day;
    private WeatherHourly[] hour;
}
