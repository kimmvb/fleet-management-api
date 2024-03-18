package com.fleetmanagement.fleetmanagementapi;

import com.fleetmanagement.fleetmanagementapi.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class FleetManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FleetManagementApiApplication.class, args);
    }

}
