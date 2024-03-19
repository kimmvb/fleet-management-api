package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
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
import java.util.Arrays;
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

        Taxi taxi = new Taxi();
        taxi.setId(6418);
        taxi.setPlate("4164DS");
        // Datos de ejemplo, creación de elemento Taxi
        Trajectory trajectory = new Trajectory();
        trajectory.setId(1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        trajectory.setDate(timestamp);
        trajectory.setTaxi(taxi);
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
        Page<Trajectory> result = trajectoryService.getTrajectoriesById(trajectory.getTaxi().getId(),
                0, 10);

        assertEquals(trajectoryPage, result);
    }

    @DisplayName("should return a trajectory from a taxi after giving a taxi ID and a date")
    @Test
    void getTrajectoriesByIdAndDate() {
        //Mock de clase TaxiRepository
        TrajectoryRepository trajectoryRepositoryMock = Mockito.mock(TrajectoryRepository.class);

        Taxi taxi = new Taxi();
        taxi.setId(6418);
        taxi.setPlate("4164DS");
        // Datos de ejemplo, creación de elemento Taxi
        Trajectory trajectory = new Trajectory();
        trajectory.setId(1);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        trajectory.setDate(timestamp);
        trajectory.setTaxi(taxi);
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
        Page<Trajectory> result = trajectoryService.getTrajectoriesByIdAndDate(trajectory.getTaxi().getId(),
                trajectory.getDate().toString(),
                0, 10);

        assertEquals(trajectoryPage, result);
    }

    @DisplayName("should return the last locations of all taxis")
    @Test
    void getLastLocation() {
        //Mock de clase TaxiRepository
        TrajectoryRepository trajectoryRepositoryMock = Mockito.mock(TrajectoryRepository.class);

        Taxi taxi = new Taxi();
        taxi.setId(6418);
        taxi.setPlate("4164DS");
        // Datos de ejemplo, creación de elemento Taxi
        Trajectory trajectory1 = new Trajectory();
        trajectory1.setId(1);
        String timestampString1 = "2021-04-23 12:34:56.789";
        Timestamp timestamp1 = Timestamp.valueOf(timestampString1);
        trajectory1.setDate(timestamp1);
        trajectory1.setTaxi(taxi);
        trajectory1.setLatitude(1542646);
        trajectory1.setLongitude(145262565);

        Trajectory trajectory2 = new Trajectory();
        trajectory2.setId(2);
        String timestampString2 = "2022-04-23 12:34:56.789";
        Timestamp timestamp2 = Timestamp.valueOf(timestampString2);
        trajectory2.setDate(timestamp2);
        trajectory2.setTaxi(taxi);
        trajectory2.setLatitude(1542646);
        trajectory2.setLongitude(145262565);
        // Se crea una lista de elementos de tipo Taxi
        List<Trajectory> trajectoryList = Arrays.asList(trajectory1,trajectory2);

        System.out.print(trajectoryList);
        // Se crea una página con la lista de taxis
        Page<Trajectory> trajectoryPage = new PageImpl<>(trajectoryList);

        System.out.print(trajectoryPage.getContent());

        // Se hace un mock de lo que retornará taxiRepository
        Mockito.when(trajectoryRepositoryMock.findLatestTrajectoriesOfAllTaxis(Mockito.any(Pageable.class)))
                .thenReturn(trajectoryPage);

        // Nueva instancia de la clase por probar
        TrajectoryService trajectoryService = new TrajectoryService(trajectoryRepositoryMock);

        // Se llama al resultado de getTaxis
        Page<Trajectory> result = trajectoryService.getTaxisLastLocation(0, 10);

        assertEquals(trajectoryPage, result);
    }
}