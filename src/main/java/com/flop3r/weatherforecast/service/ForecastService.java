package com.flop3r.weatherforecast.service;

import com.flop3r.weatherforecast.entity.response.ForecastResponse;
import com.flop3r.weatherforecast.entity.response.WeatherDataResponse;
import com.flop3r.weatherforecast.provider.ForecastProvider;
import com.flop3r.weatherforecast.domain.ForecastRequestDetail;
import com.flop3r.weatherforecast.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ForecastService is a service class responsible for processing weather forecast requests.
 *
 * This class interacts with ForecastProvider to fetch the weather forecast data and then
 * transforms it into a ForecastResponse.
 */
@Service
public class ForecastService {

    final private ForecastProvider forecastProvider;

    /**
     * Constructor.
     *
     * @param forecastProvider The provider used to fetch weather forecast data.
     */
    @Autowired
    public ForecastService(ForecastProvider forecastProvider) {
        this.forecastProvider = forecastProvider;
    }

    /**
     * Retrieves the weather forecast response for the given request details.
     *
     * @param forecastRequestDetail The details of the forecast request, including location, date, extc.
     * @return ForecastResponse containing the processed weather forecast data.
     * @throws Exception if an error occurs while fetching or transforming the forecast data.
     */
    public ForecastResponse getResponse(ForecastRequestDetail forecastRequestDetail)
            throws Exception {
        WeatherDataResponse response = forecastProvider.getForecast(forecastRequestDetail);

        return ResponseTransformer.transformWeatherToForecast(response);
    }

    /**
     * Retrieves the weather forecasts for the 5 largest Polish cities.
     *
     * @param days The number of days for the forecast.
     * @param dt The date for the forecast.
     * @param lang The language for the forecast.
     * @return A list of ForecastResponse for the largest cities.
     */
    public List<ForecastResponse> getForecastsLargestCities(
            Integer days,
            LocalDate dt,
            String lang) {
        // List of the 5 largest population Polish cities
        List<String> largestCities = Arrays.asList("Warsaw", "Krakow", "Lodz", "Wroclaw", "Poznan");
        List<ForecastResponse> responses = new ArrayList<>();

        // Loop through each city and fetch the forecast
        for (String city : largestCities) {
            try {
                // Create the request detail for each city
                ForecastRequestDetail requestDetail = ForecastRequestDetail.builder()
                        .location(city)
                        .days(days)
                        .date(dt)
                        .language(lang)
                        .build();

                // Get the forecast response for each city
                ForecastResponse response = getResponse(requestDetail);
                responses.add(response);
            } catch (Exception e) {
                // Handle exceptions, optionally log or add error handling logic here
                e.printStackTrace();
            }
        }

        return responses;
    }
}
