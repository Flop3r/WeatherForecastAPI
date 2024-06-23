package com.example.weatherforecast.res;

import com.example.weatherforecast.res.domain.ForecastRequestDetail;
import com.example.weatherforecast.res.entity.response.ForecastResponse;
import com.example.weatherforecast.res.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/** ForecastController handles HTTP requests for weather forecasts.
 *
 * This controller provides an endpoint to retrieve weather forecasts based on
 * the specified parameters such as location, date, number of days, and language.
 */
@RestController
@RequestMapping(path = "api/v1")
public class ForecastController {

    private final ForecastService forecastService;

    /**
     * Constructor.
     *
     * @param forecastService The service used to fetch weather forecasts.
     */
    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    /**
     * Retrieves the weather forecast based on the specified parameters.
     * Retrieves the weather forecast based on the specified parameters.
     *
     * @param q      The location for the forecast.
     * @param days   The number of days for the forecast (default is 3).
     * @param dt     The date for the forecast (optional).
     * @param lang   The language for the forecast (default is "eng").
     * @return ForecastResponse containing the weather forecast data.
     * @throws Exception if an error occurs while fetching the forecast data.
     */
    @GetMapping(path = "/forecast")
    public ForecastResponse weatherForecast(
            @RequestParam String q,
            @RequestParam(required = false, defaultValue = "3") Integer days,
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE) LocalDate dt,
            @RequestParam(required = false, defaultValue = "eng") String lang) throws Exception {

        final ForecastRequestDetail forecastRequestDetail = ForecastRequestDetail.builder()
                .location(q)
                .days(days)
                .date(dt)
                .language(lang)
                .build();

        return forecastService.getResponse(forecastRequestDetail);
    }
}
