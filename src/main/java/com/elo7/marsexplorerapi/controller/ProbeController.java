package com.elo7.marsexplorerapi.controller;

import com.elo7.marsexplorerapi.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/probes")
public class ProbeController {

//    private final PlanetRepository dao;
//
//    @Autowired
//    ProbeController(PlanetRepository dao){
//        this.dao = dao;
//    }

    @GetMapping()
    public PlanetActionResponse getLandedProbes() {

        PlanetActionResponse mars = new PlanetActionResponse(Planet.mars.getProbes(), Planet.mars.getPositions());
        return mars;

    }

    @PostMapping()
    public PlanetActionResponse land(@RequestBody ProbeRequest probeRequest) {
        try {

            Probe probe = probeRequest.toProbe();
            probe.land(Planet.mars);
            PlanetActionResponse mars = new PlanetActionResponse(Planet.mars.getProbes(), Planet.mars.getPositions());
            return mars;


        } catch (Exception ex) {

            throw ex;

        }
    }

    @PutMapping("/{id}")
    public PlanetActionResponse setAction(@PathVariable("id") Integer id, @RequestBody ActionRequest request) {
        try {

            Optional<Probe> probe = Planet.mars.findProbeById(id);

            if (probe.isPresent()) {
                Probe currentProbe = probe.get();

                if (request.getAction() == ProbeCommand.R || request.getAction() == ProbeCommand.L) {
                    currentProbe.spin(request.getAction());
                }
                if (request.getAction() == ProbeCommand.M) {
                    currentProbe.move(Planet.mars);
                }

            }

            PlanetActionResponse mars = new PlanetActionResponse(Planet.mars.getProbes(), Planet.mars.getPositions());
            return mars;

        } catch (Exception ex) {

            throw ex;

        }
    }
}

class ProbeRequest {

    private Position position;
    private Direction direction;

    Probe toProbe() {
        return new Probe(0, direction, position);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }
}

class ActionRequest {

    private ProbeCommand action;

    public ProbeCommand getAction() {
        return action;
    }
}

class PlanetActionResponse {

    PlanetActionResponse(List<Probe> probes, List<Position> positions) {

        for (Position position : positions) {
            PositionResponse positionResponse = new PositionResponse(position.getX(), position.getY());
            for (Probe probe : probes) {
                if (probe.getPosition().equals(position)) {
                    positionResponse.setProbe(probe);
                }
            }

            surface.add(positionResponse);
        }
    }

    private List<PositionResponse> surface = new ArrayList<>();

    public List<PositionResponse> getSurface() {
        return surface;
    }
}

@JsonInclude(JsonInclude.Include.NON_NULL)
class PositionResponse {

    private Integer x;
    private Integer y;
    private Probe probe;

    PositionResponse(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Probe getProbe() {
        return probe;
    }

    Probe setProbe(Probe probe) {
        this.probe = probe;
        return probe;
    }
}