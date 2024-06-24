package com.flop3r.weatherforecast.domain.forecast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Location {
    String city;
    String country;
}
