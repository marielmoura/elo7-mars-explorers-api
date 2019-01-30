package com.elo7.marsexplorerapi.repository;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.model.Probe;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProbeRepository {

    public static List<Probe> probesLanded = new ArrayList<>();

    public static Probe add(Probe newProbe) {

        Integer id = ProbeRepository.probesLanded.size() + 1;
        Probe _newProbe = new Probe(id, newProbe.getDirection(), newProbe.getPosition());
        ProbeRepository.probesLanded.add(_newProbe);
        return _newProbe;

    }

    public static Optional<Probe> findById(Integer id) {

        Optional<Probe> currentProbe = ProbeRepository.probesLanded.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        return currentProbe;
    }

}
