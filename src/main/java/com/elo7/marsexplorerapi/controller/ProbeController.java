package com.elo7.marsexplorerapi.controller;

import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.model.ProbeCommand;
import com.elo7.marsexplorerapi.repository.PlanetRepository;
import com.elo7.marsexplorerapi.repository.ProbeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProbeController {

    @GetMapping("/api/probes")
    public List<Probe> doGet() {

        return ProbeRepository.landedProbes;

    }

    @PostMapping("/api/probes")
    public Probe doPost(@RequestBody Probe newProbe) {

        Probe _newProbe = ProbeRepository.add(newProbe);
        PlanetRepository.mars.setProbesLanded(ProbeRepository.landedProbes);
        return _newProbe;

    }

    @PutMapping("/api/probes/{id}/spin/right")
    public List<Probe> doPutSpinRight(@PathVariable("id") Integer id) {

        Optional<Probe> probeToSpin = ProbeRepository.findById(id);

        if (probeToSpin.isPresent()) {
            ProbeRepository.save(probeToSpin.get(), ProbeCommand.Right);
        }

        return ProbeRepository.landedProbes;
    }

    @PutMapping("/api/probes/{id}/spin/left")
    public List<Probe> doPutSpinLeft(@PathVariable("id") Integer id) {

        try {

            Optional<Probe> probeToSpin = ProbeRepository.findById(id);

            if (probeToSpin.isPresent()) {
                ProbeRepository.save(probeToSpin.get(), ProbeCommand.Left);
            }

            return ProbeRepository.landedProbes;

        } catch (Exception ex) {
            throw ex;
        }

    }

    @PutMapping("/api/probes/{id}/move")
    public List<Probe> doPutMove(@PathVariable("id") Integer id) {

        Optional<Probe> probeToSpin = ProbeRepository.findById(id);

        if (probeToSpin.isPresent()) {
            ProbeRepository.save(probeToSpin.get(), ProbeCommand.Move);
        }

        return ProbeRepository.landedProbes;
    }

}
