package com.flop3r.weatherforecast.domain.forecast;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WeatherHourly {

    private LocalDateTime time;
    private Float windspeed;
}
