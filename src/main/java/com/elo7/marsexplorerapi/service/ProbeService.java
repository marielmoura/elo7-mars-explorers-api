package com.elo7.marsexplorerapi.service;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.repository.PlanetRepository;
import com.elo7.marsexplorerapi.repository.ProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    @Autowired
    private ProbeRepository repo;

    public void add(Probe probe) {
        repo.save(probe);
    }

}
