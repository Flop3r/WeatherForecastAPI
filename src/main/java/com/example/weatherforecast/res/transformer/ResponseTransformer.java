package com.example.weatherforecast.res.transformer;

import com.example.weatherforecast.res.entity.response.ForecastResponse;
import com.example.weatherforecast.res.entity.response.WeatherApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseTransformer {

    static public ForecastResponse transformWeatherToForecast(WeatherApiResponse responseWeather) {
        ForecastResponse forecastResponse = new ForecastResponse();
        forecastResponse.setLocation(responseWeather.getLocation());
        forecastResponse.setWeatherForecasts(
                responseWeather.getForecast().getForecastDay());

        return forecastResponse;
    }
}
