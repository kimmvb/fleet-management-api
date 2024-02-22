package com.fleetmanagement.fleetmanagementapi.repositories;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Id> {
}
