package com.flop3r.weatherforecast.service;

import com.flop3r.weatherforecast.entity.response.ForecastResponse;
import com.flop3r.weatherforecast.entity.response.WeatherDataResponse;
import com.flop3r.weatherforecast.provider.ForecastProvider;
import com.flop3r.weatherforecast.domain.ForecastRequestDetail;
import com.flop3r.weatherforecast.transformer.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
