package com.elo7.marsexplorerapi.controller;

import com.elo7.marsexplorerapi.model.Planet;
import com.elo7.marsexplorerapi.model.Probe;
import com.elo7.marsexplorerapi.model.ProbeCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/probes")
public class ProbeController {

    @GetMapping()
    public List<Probe> get() {

        return Planet.mars.getLandedProbes();

    }

    @PostMapping()
    public Probe landNewProbe(@RequestBody Probe newProbe) {
        try {

            return Planet.mars.landProbe(newProbe);

        } catch (Exception ex) {

            throw ex;

        }
    }

    @PutMapping("/{id}/spin/right")
    public Probe spinProbeRight(@PathVariable("id") Integer id) {
        try {

            return Planet.mars.spinProbe(id, ProbeCommand.RIGHT);

        } catch (Exception ex) {

            throw ex;

        }
    }

    @PutMapping("/{id}/spin/left")
    public Probe spinProbeLeft(@PathVariable("id") Integer id) {
        try {

            return Planet.mars.spinProbe(id, ProbeCommand.LEFT);

        } catch (Exception ex) {

            throw ex;

        }

    }

    @PutMapping("/{id}/move")
    public Probe moveProbe(@PathVariable("id") Integer id) {
        try {

            return Planet.mars.moveProbe(id);

        } catch (Exception ex) {

            throw ex;

        }
    }

}
