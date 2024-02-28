package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Trajectory;
import com.fleetmanagement.fleetmanagementapi.repositories.TrajectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajectoryService {

    private final TrajectoryRepository trajectoryRepository;

    @Autowired
    public TrajectoryService(TrajectoryRepository trajectoryRepository) {
        this.trajectoryRepository = trajectoryRepository;
    }

    public Page<Trajectory> getTrajectoriesById(Integer taxi_id, Pageable pageable){
        return trajectoryRepository.findByTaxiId(taxi_id, pageable);
    }

    public Page<Trajectory> getTrajectoriesByIdAndDate(Integer taxi_id, String date, Pageable pageable) {
        return trajectoryRepository.findByTaxiIdAndDate(taxi_id, date, pageable);
    }
}
