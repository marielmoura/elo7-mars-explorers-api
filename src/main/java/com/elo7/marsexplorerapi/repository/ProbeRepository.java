package com.elo7.marsexplorerapi.repository;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.model.ProbeCommand;
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

    public static void save(Probe probe, ProbeCommand probeCommand) {
        ProbeRepository.probesLanded.remove(probe);

        if (!probeCommand.equals(ProbeCommand.Move)) {
            probe.spin(probeCommand);
        }

        if (probeCommand.equals(ProbeCommand.Move)) {
            probe.move();
        }

        ProbeRepository.probesLanded.add(probe);
        PlanetRepository.mars.setProbesLanded(ProbeRepository.probesLanded);
    }

}
