package com.flop3r.weatherforecast.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("WEATHER FORECAST API")
                        .version("1.0.0")
                        .description("API provides weather forecast. It utilizes the WeatherAPI" +
                                " service to fetch weather data and presents the forecast" )
                        .contact(new Contact()
                                .name("Franciszek P")
                                .email("dev-team@gmail.com")
                                .url("https://github.com/Flop3r"))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
