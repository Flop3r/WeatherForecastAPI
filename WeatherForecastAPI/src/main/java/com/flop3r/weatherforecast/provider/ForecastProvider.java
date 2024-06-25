package com.flop3r.weatherforecast.provider;

import com.flop3r.weatherforecast.entity.response.WeatherDataResponse;
import com.flop3r.weatherforecast.domain.ForecastRequestDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * ForecastProvider is a service class responsible for fetching weather forecast data
 * from an external API.
 *
 * This class uses Spring's RestTemplate to make HTTP requests and retrieves weather
 * forecast data based on the details provided in the ForecastRequestDetail object.
 */
@Service
public class ForecastProvider {

    /**
     * The API key used for authenticating requests to the external weather API.
     * This value is injected from the application's configuration properties.
     */
    @Value("${api.key}")
    private String apiKey;

    /**
     * The base URL of the external weather API.
     * This value is injected from the application's configuration properties.
     */
    @Value("${weather.url}")
    private String weatherUrl;

    /**
     * Query parameters keys.
     * These keys are used to construct the query parameters for the API request.
     */
    private static final String QUERY_PARAM_LOCATION = "q";
    private static final String QUERY_PARAM_DATE = "dt";
    private static final String QUERY_PARAM_DAYS = "days";
    private static final String QUERY_PARAM_LANG = "lang";
    private static final String QUERY_PARAM_KEY = "key";

    /**
     * Fetches weather forecast data from the external API.
     *
     * @param forecastRequestDetail An object containing the details of the forecast request,
     *                              including location, date, number of days, and language.
     * @return WeatherApiResponse containing the weather forecast data.
     * @throws Exception if an error occurs while fetching the forecast data.
     */
    public WeatherDataResponse getForecast(ForecastRequestDetail forecastRequestDetail) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> requestEntity = new HttpEntity<>(null, null);

        UriComponents uriBuilder = buildUri(forecastRequestDetail);

        try {
            ResponseEntity<WeatherDataResponse> responseEntity = restTemplate.exchange(
                    uriBuilder.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    WeatherDataResponse.class
            );
            return responseEntity.getBody();
        } catch (HttpStatusCodeException e) {
            throw new Exception("Error occurred while fetching weather forecast: " + e.getMessage(), e);
        }
    }

    /**
     * Utility method to build the URI for the API request.
     *
     * @param forecastRequestDetail The details of the forecast request.
     * @return UriComponents representing the built URI.
     */
    private UriComponents buildUri(ForecastRequestDetail forecastRequestDetail) {
        return UriComponentsBuilder
                .fromHttpUrl(weatherUrl)
                .queryParam(QUERY_PARAM_LOCATION, forecastRequestDetail.getLocation())
                .queryParam(QUERY_PARAM_DATE, forecastRequestDetail.getDate())
                .queryParam(QUERY_PARAM_DAYS, forecastRequestDetail.getDays())
                .queryParam(QUERY_PARAM_KEY, apiKey)
                .build();
    }
}
