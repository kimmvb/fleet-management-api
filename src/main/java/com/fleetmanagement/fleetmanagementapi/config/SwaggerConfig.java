package com.fleetmanagement.fleetmanagementapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fleet Management API")
                        .version("1.0.0")
                        .description("REST API for a taxi fleet management system in Beijing, China. " +
                                "Query the locations of nearly 10 thousand taxis in real-time and ensure an optimal " +
                                "user experience.")
                );
    }
}
