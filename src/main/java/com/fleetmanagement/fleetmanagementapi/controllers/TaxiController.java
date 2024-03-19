package com.fleetmanagement.fleetmanagementapi.controllers;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.services.TaxiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@Tag(name = "taxi", description = "Endpoints to query taxis")
@RequestMapping(path = "api/v1/taxi")
public class TaxiController {

    private final TaxiService taxiService;

    @Autowired
    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Operation(summary = "Retrieve a list of registered taxis")
    @GetMapping
    public Page<Taxi> getTaxis(@Parameter(name = "pageNumber", description = "Page Number", example = "0")
                               int pageNumber,
                               @Parameter(name = "pageSize", description = "Page Size", example = "10")
                               int pageSize) {
        return taxiService.getTaxis(pageNumber, pageSize);
    }
}