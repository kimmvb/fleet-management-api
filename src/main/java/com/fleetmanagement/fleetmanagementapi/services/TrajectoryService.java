package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Trajectory;
import com.fleetmanagement.fleetmanagementapi.repositories.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TrajectoryService {

    private final TrajectoryRepository trajectoryRepository;

    @Autowired
    public TrajectoryService(TrajectoryRepository trajectoryRepository) {
        this.trajectoryRepository = trajectoryRepository;
    }

    public Page<Trajectory> getTrajectoriesById(Integer taxi_id, int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);

        Page<Trajectory> trajectoriesResults = trajectoryRepository.findByTaxiId(taxi_id, page);

        if (trajectoriesResults.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Taxi ID not found: " + taxi_id);
        }
        return trajectoriesResults;
    }

    public Page<Trajectory> getTrajectoriesByIdAndDate(Integer taxi_id, String date, int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);

        Page<Trajectory> trajectoriesResults = trajectoryRepository.findByTaxiIdAndDate(taxi_id, date, page);

        if (trajectoriesResults.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Trajectories not found from: " + taxi_id);
        }
        return trajectoriesResults;
    }

    public Page<Trajectory> getTaxisLastLocation( int pageNumber, int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);

        Page<Trajectory> trajectoriesResults = trajectoryRepository.findLatestTrajectoriesOfAllTaxis(page);

        if (trajectoriesResults.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Last locations not found");
        }
        return trajectoriesResults;
    }

//    public Page<Trajectory> getTrajectoriesByIdAndDateAndSend(Integer taxi_id, String date, Pageable pageable) {
//        Page<Trajectory> trajectoriesResults = trajectoryRepository.findByTaxiIdAndDate(taxi_id, date, pageable);
//
//        if (trajectoriesResults.isEmpty()) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Trajectories not found from: " + taxi_id);
//        }
//        return trajectoriesResults;
//    }
}
