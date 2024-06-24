package com.flop3r.weatherforecast.res.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LocationEntity represents the geographical location details.
 *
 * Fields:
 * - city (String): The name of the city.
 * - country (String): The name of the country.
 */
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationEntity {

    @JsonProperty("name")
    String city;
    @JsonProperty("country")
    String country;
}
