package com.fleetmanagement.fleetmanagementapi.services;

import com.fleetmanagement.fleetmanagementapi.models.Taxi;
import com.fleetmanagement.fleetmanagementapi.repositories.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
public class TaxiService {

    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiService(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    public Page<Taxi> getTaxis(@PageableDefault(sort = {"id"},
            direction = Sort.Direction.ASC) Pageable pageable) {
        return taxiRepository.findAll(pageable);
    }

}
