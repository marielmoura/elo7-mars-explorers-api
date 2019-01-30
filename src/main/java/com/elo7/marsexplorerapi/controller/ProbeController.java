package com.elo7.marsexplorerapi.controller;

import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.repository.PlanetRepository;
import com.elo7.marsexplorerapi.repository.ProbeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProbeController {

    @GetMapping("/api/probes")
    public List<Probe> doGet() {

        return ProbeRepository.probesLanded;

    }

    @PostMapping("/api/probes")
    public Probe doPost(@RequestBody Probe newProbe) {

        Probe _newProbe = ProbeRepository.add(newProbe);
        PlanetRepository.mars.setProbesLanded(ProbeRepository.probesLanded);
        return _newProbe;

    }

    @PutMapping("/api/probes/{id}/spin/right")
    public List<Probe> doPutSpinRight(@PathVariable("id") Integer id) {

        Optional<Probe> probeToSpin = ProbeRepository.probesLanded.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        if (probeToSpin.isPresent()) {
            Probe _probeToSpin = probeToSpin.get();
            ProbeRepository.probesLanded.remove(_probeToSpin);
            _probeToSpin.spinRight();
            ProbeRepository.probesLanded.add(_probeToSpin);
            PlanetRepository.mars.setProbesLanded(ProbeRepository.probesLanded);
        }

        return ProbeRepository.probesLanded;
    }

    @PutMapping("/api/probes/{id}/spin/left")
    public List<Probe> doPutSpinLeft(@PathVariable("id") Integer id) {

        try {

            Optional<Probe> probeToSpin = ProbeRepository.findById(id);

            if (probeToSpin.isPresent()) {
                Probe _probeToSpin = probeToSpin.get();
                ProbeRepository.probesLanded.remove(_probeToSpin);
                _probeToSpin.spinLeft();
                ProbeRepository.probesLanded.add(_probeToSpin);
                PlanetRepository.mars.setProbesLanded(ProbeRepository.probesLanded);
            }

            return ProbeRepository.probesLanded;

        } catch (Exception ex) {
            throw ex;
        }

    }

    @PutMapping("/api/probes/{id}/move")
    public List<Probe> doPutMove(@PathVariable("id") Integer id) {

        Optional<Probe> probeToSpin = ProbeRepository.probesLanded.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        if (probeToSpin.isPresent()) {
            Probe _probeToSpin = probeToSpin.get();
            ProbeRepository.probesLanded.remove(_probeToSpin);
            _probeToSpin.move();
            ProbeRepository.probesLanded.add(_probeToSpin);
            PlanetRepository.mars.setProbesLanded(ProbeRepository.probesLanded);
        }

        return ProbeRepository.probesLanded;
    }

}
