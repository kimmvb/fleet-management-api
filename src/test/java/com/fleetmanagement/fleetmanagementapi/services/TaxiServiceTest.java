package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.repositories.TaxiRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaxiServiceTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnMockTaxiList() {

        //Mock de clase TaxiRepository
        TaxiRepository taxiRepositoryMock = Mockito.mock(TaxiRepository.class);

        // Datos de ejemplo, creación de elemento Taxi
        Taxi taxi = new Taxi();
        taxi.setId(17);
        taxi.setPlate("SSHJ45");
        // Se crea una lista de elementos de tipo Taxi
        List<Taxi> taxiList = Collections.singletonList(taxi);
        // Se crea una página con la lista de taxis
        Page<Taxi> taxiPage = new PageImpl<>(taxiList);

        // Se hace un mock de lo que retornará taxiRepository
        Mockito.when(taxiRepositoryMock.findAll(Mockito.any(Pageable.class))).thenReturn(taxiPage);

        // Nueva instancia de la clase por probar
        TaxiService taxiService = new TaxiService(taxiRepositoryMock);

        // Se llama al resultado de getTaxis
        Page<Taxi> result = taxiService.getTaxis(PageRequest.of(1, 10));

        System.out.print(result);

        assertEquals(taxiPage, result);

    }
}