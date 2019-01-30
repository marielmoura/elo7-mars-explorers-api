package com.elo7.marsexplorerapi.controller;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.model.ProbeCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/probes")
public class ProbeController {

    @GetMapping()
    public List<Probe> get() {

        return Planet.mars.getLandedProbes();

    }

    @PostMapping()
    public String post(@RequestBody Probe newProbe) {

        return Planet.mars.addProbe(newProbe);

    }

    @PutMapping("/{id}/spin/right")
    public List<Probe> putSpinRight(@PathVariable("id") Integer id) {

        Optional<Probe> probeToSpin = Planet.mars.findProbeById(id);

        if (probeToSpin.isPresent()) {
            Planet.mars.saveProbe(probeToSpin.get(), ProbeCommand.RIGHT);
        }

        return Planet.mars.getLandedProbes();
    }

    @PutMapping("/{id}/spin/left")
    public List<Probe> putSpinLeft(@PathVariable("id") Integer id) {

        try {

            Optional<Probe> probeToSpin = Planet.mars.findProbeById(id);

            if (probeToSpin.isPresent()) {
                Planet.mars.saveProbe(probeToSpin.get(), ProbeCommand.LEFT);
            }

            return Planet.mars.getLandedProbes();

        } catch (Exception ex) {
            throw ex;
        }

    }

    @PutMapping("/{id}/move")
    public List<Probe> putMove(@PathVariable("id") Integer id) {

        Optional<Probe> probeToSpin = Planet.mars.findProbeById(id);

        if (probeToSpin.isPresent()) {
            Planet.mars.saveProbe(probeToSpin.get(), ProbeCommand.MOVE);
        }

        return Planet.mars.getLandedProbes();
    }

}
