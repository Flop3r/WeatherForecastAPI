package com.flop3r.weatherforecast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * ForecastRequestDetail is a data class representing the details required
 * to fetch weather forecast data from an external API.
 *
 * Fields:
 * - location(String): the geographical location for which the forecast is requested.
 * - days(Integar): the number of days for the forecast period.
 * - date(LocalData): the specific date for the forecast.
 * - language(String): the preferred language for the forecast response.
 *
 * Example initiation:
 * ForecastRequestDetail requestDetail = ForecastRequestDetail.builder()
 *     .location("New York")
 *     .days(5)
 *     .date(LocalDate.now())
 *     .language("en")
 *     .build();
 */

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ForecastRequestDetail {
    private String location;
    private Integer days;
    private LocalDate date;
}
