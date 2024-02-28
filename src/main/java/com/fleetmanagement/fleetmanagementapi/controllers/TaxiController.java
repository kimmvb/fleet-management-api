package com.fleetmanagement.fleetmanagementapi.controllers;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.services.TaxiService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "taxi", description = "Endpoints to query taxis")
@RequestMapping(path = "api/v1/taxi")
public class TaxiController {

    private final TaxiService taxiService;

    @Autowired
    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @GetMapping
    public Page<Taxi> getTaxis(@Parameter(name = "pageable", description = "Pages description",
            example = "{\"page\": 0, \"size\": 10, \"sort\": [\"id,asc\"]}")
                               @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return taxiService.getTaxis(pageable);
    }
}
//Yo como clienta de la API REST requiero un endpoint para consultar todas las ubicaciones...
// de un taxi dado el id y una fecha.

//Error más del total de páginas