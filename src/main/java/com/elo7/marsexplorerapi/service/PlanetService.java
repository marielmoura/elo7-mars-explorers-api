package com.elo7.marsexplorerapi.service;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    @Autowired
    private PlanetRepository repo;

    public void add(Planet planet) {
        repo.save(planet);
    }
}
