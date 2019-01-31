package com.elo7.marsexplorerapi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Planet {

    private static final Integer SIZE_X = 5;
    private static final Integer SIZE_Y = 5;
    public static final Planet mars = new Planet(SIZE_X, SIZE_Y);

    private List<Position> positions = new ArrayList<>();
    private List<Probe> landedProbes = new ArrayList<>();

    Logger logger = LogManager.getLogger(this);

    public Planet(Integer sizeX, Integer sizeY) {

        for (int posY = 0; posY < sizeY; posY++) {
            for (int posX = 0; posX < sizeX; posX++) {
                Position planetPosition = new Position(posX, posY);
                positions.add(planetPosition);
            }
        }

    }

    public boolean isPositionInAreaRange(Position position) {
        return positions.contains(position);
    }

    public List<Position> getBusyPositions() {

        return landedProbes.stream().map(probes -> probes.getPosition())
                .collect(Collectors.toList());

    }

    public List<Position> getFreePositions() {

        List<Position> freePositions = ((List) ((ArrayList) positions).clone());
        freePositions.removeAll(getBusyPositions());

        return freePositions;
    }

    public boolean isPositionBusy(Position position) {

        return getBusyPositions().contains(position);
    }

    public Position nextFreePosition() {

        Position freePosition = new Position(0, 0);

        if (getFreePositions().stream().findFirst().isPresent())
            freePosition = getFreePositions().stream().findFirst().get();

        return freePosition;
    }

    public Probe landProbe(Probe newProbe) {

        Position landingPosition = newProbe.getPosition();

        if (!isPositionInAreaRange(landingPosition)) {
            landingPosition = new Position(0, 0);
        }

        if (isPositionBusy(landingPosition)) {
            landingPosition = nextFreePosition();
        }

        Integer id = landedProbes.size() + 1;
        Probe _newProbe = new Probe(id, newProbe.getDirection(), landingPosition);
        landedProbes.add(_newProbe);
        drawConsoleSurface();
        return _newProbe;
    }

    public Optional<Probe> findProbeById(Integer id) {

        Optional<Probe> currentProbe = landedProbes.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        return currentProbe;
    }

    public Probe spinProbe(Integer id, ProbeCommand probeCommand) {

        Optional<Probe> probeToSpin = this.findProbeById(id);

        if (probeToSpin.isPresent()) {
            Probe currentProbe = probeToSpin.get();
            Direction newDirection = currentProbe.getNewDirection(probeCommand);
            landedProbes.remove(currentProbe);
            currentProbe = new Probe(id, newDirection, currentProbe.getPosition());
            landedProbes.add(currentProbe);
            drawConsoleSurface();
            return currentProbe;
        }

        return null;

    }

    public Probe moveProbe(Integer id) {

        Optional<Probe> probeToSpin = this.findProbeById(id);

        if (probeToSpin.isPresent()) {
            Probe currentProbe = probeToSpin.get();
            Position newPosition = currentProbe.getNewPosition();

            if (isPositionBusy(newPosition)) {
                logger.warn("[WARNING] Probe is already in this position: posX: " + newPosition.getX() + " posY: " + newPosition.getY());
                return currentProbe;
            }

            landedProbes.remove(currentProbe);
            currentProbe = new Probe(id, currentProbe.getDirection(), newPosition);
            landedProbes.add(currentProbe);
            drawConsoleSurface();
            return currentProbe;
        }

        return null;
    }

    public List<Probe> getLandedProbes() {
        return landedProbes;
    }

    public void drawConsoleSurface() {

        logger.info("");

        StringBuilder marsSurface = new StringBuilder();

        for (Integer posY = SIZE_X - 1; posY > -1; posY--) {

            marsSurface = new StringBuilder();

            for (Integer posX = 0; posX < SIZE_X; posX++) {

                String positionDraw = "====";
                Position currentPosition = new Position(posX, posY);

                for (Probe probeOnSoil : landedProbes) {
                    if (currentPosition.equals(probeOnSoil.getPosition())) {
                        positionDraw = "P" + String.format("%02d", probeOnSoil.getId()) + probeOnSoil.getDirection();
                        continue;
                    }
                }

                marsSurface.append(positionDraw);
            }

            logger.info("Y" + posY + " " + marsSurface);
        }

        logger.info("");
    }

}
