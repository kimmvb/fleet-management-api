package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Trajectory;
import com.fleetmanagement.fleetmanagementapi.repositories.TrajectoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrajectoryServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("should return a trajectory from a taxi after giving a taxi ID")
    @Test
    void getTrajectoriesById() {
        //Mock de clase TaxiRepository
        TrajectoryRepository trajectoryRepositoryMock = Mockito.mock(TrajectoryRepository.class);

        // Datos de ejemplo, creación de elemento Taxi
        Trajectory trajectory = new Trajectory();
        trajectory.setId(1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        trajectory.setDate(timestamp);
        trajectory.setTaxi_id(6418);
        trajectory.setLatitude(1542646);
        trajectory.setLongitude(145262565);
        // Se crea una lista de elementos de tipo Taxi
        List<Trajectory> trajectoryList = Collections.singletonList(trajectory);
        // Se crea una página con la lista de taxis
        Page<Trajectory> trajectoryPage = new PageImpl<>(trajectoryList);

        // Se hace un mock de lo que retornará taxiRepository
        Mockito.when(trajectoryRepositoryMock.findByTaxiId(Mockito.anyInt(),
                Mockito.any(Pageable.class))).thenReturn(trajectoryPage);

        // Nueva instancia de la clase por probar
        TrajectoryService trajectoryService = new TrajectoryService(trajectoryRepositoryMock);

        // Se llama al resultado de getTaxis
        Page<Trajectory> result = trajectoryService.getTrajectoriesById(trajectory.getTaxi_id(),
                PageRequest.of(0, 10));

        assertEquals(trajectoryPage, result);
    }

    @DisplayName("should return a trajectory from a taxi after giving a taxi ID and a date")
    @Test
    void getTrajectoriesByIdAndDate() {
        //Mock de clase TaxiRepository
        TrajectoryRepository trajectoryRepositoryMock = Mockito.mock(TrajectoryRepository.class);

        // Datos de ejemplo, creación de elemento Taxi
        Trajectory trajectory = new Trajectory();
        trajectory.setId(1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        trajectory.setDate(timestamp);
        trajectory.setTaxi_id(6418);
        trajectory.setLatitude(1542646);
        trajectory.setLongitude(145262565);
        // Se crea una lista de elementos de tipo Taxi
        List<Trajectory> trajectoryList = Collections.singletonList(trajectory);
        // Se crea una página con la lista de taxis
        Page<Trajectory> trajectoryPage = new PageImpl<>(trajectoryList);

        // Se hace un mock de lo que retornará taxiRepository
        Mockito.when(trajectoryRepositoryMock.findByTaxiIdAndDate(Mockito.anyInt(), Mockito.anyString(),
                Mockito.any(Pageable.class))).thenReturn(trajectoryPage);

        // Nueva instancia de la clase por probar
        TrajectoryService trajectoryService = new TrajectoryService(trajectoryRepositoryMock);

        // Se llama al resultado de getTaxis
        Page<Trajectory> result = trajectoryService.getTrajectoriesByIdAndDate(trajectory.getTaxi_id(),
                trajectory.getDate().toString(),
                PageRequest.of(0, 10));

        assertEquals(trajectoryPage, result);
    }
}