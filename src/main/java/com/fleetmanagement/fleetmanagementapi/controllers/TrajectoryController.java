package com.fleetmanagement.fleetmanagementapi.controllers;

import com.fleetmanagement.fleetmanagementapi.models.Trajectory;
import com.fleetmanagement.fleetmanagementapi.services.TrajectoryService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "trajectory", description = "Endpoints to query trajectories")
@RequestMapping(path = "api/v1/trajectory")
public class TrajectoryController {

    private final TrajectoryService trajectoryService;

    @Autowired
    public TrajectoryController(TrajectoryService trajectoryService) {
        this.trajectoryService = trajectoryService;
    }

    @GetMapping(path = "/{taxi_id}")
    public Page<Trajectory> getTrajectoriesById(@PathVariable("taxi_id") @Parameter(name = "taxi_id", description = "Unique taxi ID", example = "6418")
                                                Integer taxi_id, @Parameter(name = "pageable",
            description = "Pages description", example = "{\"page\": 0, \"size\": 10, \"sort\": [\"id,asc\"]}")
                                                @PageableDefault(page = 0, size = 10) Pageable pageable) {
        return trajectoryService.getTrajectoriesById(taxi_id, pageable);
    }

    @GetMapping(path = "/{taxi_id}/{date}")
    public Page<Trajectory> getTrajectoriesByIdAndDate(
            @PathVariable("taxi_id") @Parameter(name = "taxi_id", description = "Unique taxi ID", example = "6418")
            Integer taxi_id, @PathVariable("date") @Parameter(name = "date",
            description = "Trajectory's date: dd-mm-yyyy", example = "02-02-2008")
            String date, @Parameter(name = "pageable", description = "Pages description",
            example = "{\"page\": 0, \"size\": 10, \"sort\": [\"id,asc\"]}") @PageableDefault(page = 0, size = 10)
            Pageable pageable) {
        return trajectoryService.getTrajectoriesByIdAndDate(taxi_id, date, pageable);
    }

}
//Yo como clienta de la API REST requiero un endpoint para consultar todas las ubicaciones...
// de un taxi dado el id y una fecha.