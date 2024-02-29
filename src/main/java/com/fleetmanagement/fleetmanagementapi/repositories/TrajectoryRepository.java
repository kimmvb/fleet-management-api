package com.fleetmanagement.fleetmanagementapi.repositories;

import com.fleetmanagement.fleetmanagementapi.models.Trajectory;
import jakarta.persistence.Id;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrajectoryRepository extends JpaRepository<Trajectory, Id> {

    @Query("SELECT t FROM Trajectory t WHERE t.taxi_id = ?1")
    Page<Trajectory> findByTaxiId(Integer taxi_id, Pageable pageable);

    @Query("SELECT t FROM Trajectory t WHERE t.taxi_id = ?1 AND TO_CHAR(date, 'dd-MM-yyyy') = ?2")
    Page<Trajectory> findByTaxiIdAndDate(Integer taxi_id, String date, Pageable pageable);

}
