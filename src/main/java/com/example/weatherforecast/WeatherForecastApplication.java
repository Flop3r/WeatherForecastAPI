package com.example.weatherforecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeatherForecastApplication is the entry point for the Spring Boot application.
 *
 * This class contains the main method which is used to launch the application.
 * The entire application is designed to be compatible with the weather data
 * provided by www.weatherapi.com.
 */
@RestController
@SpringBootApplication
public class WeatherForecastApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherForecastApplication.class, args);
    }
}
