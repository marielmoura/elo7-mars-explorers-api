package com.elo7.marsexplorerapi.repository;

import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.model.ProbeCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProbeRepository {

    public static List<Probe> landedProbes = new ArrayList<>();

    public static Probe add(Probe newProbe) {

        Integer id = landedProbes.size() + 1;
        Probe _newProbe = new Probe(id, newProbe.getDirection(), newProbe.getPosition());
        landedProbes.add(_newProbe);
        return _newProbe;

    }

    public static Optional<Probe> findById(Integer id) {

        Optional<Probe> currentProbe = landedProbes.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        return currentProbe;
    }

    public static void save(Probe probe, ProbeCommand probeCommand) {
        landedProbes.remove(probe);

        if (!probeCommand.equals(ProbeCommand.Move)) {
            probe.spin(probeCommand);
        }

        if (probeCommand.equals(ProbeCommand.Move)) {
            probe.move(landedProbes);
        }

        landedProbes.add(probe);
        PlanetRepository.mars.setProbesLanded(landedProbes);
    }

}
