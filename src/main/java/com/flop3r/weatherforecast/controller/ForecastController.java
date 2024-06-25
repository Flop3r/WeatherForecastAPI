package com.flop3r.weatherforecast.controller;

import com.flop3r.weatherforecast.domain.ForecastRequestDetail;
import com.flop3r.weatherforecast.entity.response.ForecastResponse;
import com.flop3r.weatherforecast.service.ForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
@Tag(name = "APIs", description = "APIs")
@Validated
public class ForecastController {

    private final ForecastService forecastService;

    // Constructor for dependency injection
    @Autowired
    public ForecastController(ForecastService forecastService) {
        this.forecastService = forecastService;
    }

    /**
     * Retrieves weather forecasts based on the specified parameters such as location, date, number of days, and language.
     *
     * @param q      Locations for the forecast
     * @param days   Number of days for the forecast (default is 3)
     * @param dt     Date for the forecast (optional)
     * @return Weather forecast response
     */
    @Operation(summary = "Get weather forecasts for specified locations",
            description = "Retrieves weather forecasts based on the specified parameters such as " +
                    "location, date, number of days, and language.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(array =
                    @ArraySchema(schema = @Schema(implementation = ForecastResponse.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid input parameters", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(path = "/forecast")
    public ResponseEntity<?> weatherForecast(
            @Parameter(description = "Pass US Zipcode, UK Postcode," +
                    " Canada Postalcode, IP address," +
                    " Latitude/Longitude (decimal degree)" +
                    " or city name in English.")
            @RequestParam @NotBlank String q,
            @Parameter(description = "Number of days of weather forecast." +
                    " Value ranges from 1 to 14")
            @RequestParam(required = false, defaultValue = "3") @Min(1) Integer days,
            @Parameter(description = "Date should be between today and next 14 day" +
                    " in yyyy-MM-dd format. e.g. '2015-01-01'")
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE) LocalDate dt
    ) throws Exception {
        // Create request detail object
        ForecastRequestDetail requestDetail = new ForecastRequestDetail(q, days, dt);
        // Fetch the forecast response
        ForecastResponse response = forecastService.getResponse(requestDetail);
        // Return the response entity
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Retrieves weather forecasts for the 5 largest Polish cities.
     *
     * @param days    Number of days for the forecast (default is 3)
     * @param dt      Date for the forecast (optional)
     * @return Weather forecast response for the largest cities
     */
    @Operation(summary = "Get weather forecasts for the 5 largest Polish cities",
            description = "Retrieves weather forecasts for Warsaw, Cracow, Lodz, Wroclaw, and Poznan.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(array =
                    @ArraySchema(schema = @Schema(implementation = ForecastResponse.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping(path = "/forecast/largest-cities")
    public ResponseEntity<?> weatherForecastForLargestCities(
            @Parameter(description = "Number of days of weather forecast." +
                    " Value ranges from 1 to 14")
            @RequestParam(required = false, defaultValue = "3") @Min(1) Integer days,
            @Parameter(description = "Date should be between today and next 14 day" +
                    " in yyyy-MM-dd format. e.g. '2015-01-01'")
            @RequestParam(required = false) @DateTimeFormat(
                    iso = DateTimeFormat.ISO.DATE) LocalDate dt) {
        // Fetch the forecast response for the largest cities
        List<ForecastResponse> responses = forecastService.getForecastsLargestCities(days, dt);
        // Return the response entity
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
