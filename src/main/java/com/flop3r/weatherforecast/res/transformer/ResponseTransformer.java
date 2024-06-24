package com.flop3r.weatherforecast.res.transformer;


import com.flop3r.weatherforecast.res.entity.response.ForecastResponse;
import com.flop3r.weatherforecast.res.entity.response.WeatherDataResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseTransformer {

    static public ForecastResponse transformWeatherToForecast(WeatherDataResponse responseWeather) {
        ForecastResponse forecastResponse = new ForecastResponse();
        forecastResponse.setLocation(responseWeather.getLocation());
        forecastResponse.setWeatherForecasts(
                responseWeather.getForecast().getForecastDay());

        return forecastResponse;
    }
}
