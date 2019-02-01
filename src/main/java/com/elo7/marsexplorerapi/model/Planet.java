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

    private List<Position> positions;
    private List<Probe> probes;

    Logger logger = LogManager.getLogger(this);

    public Planet(Integer sizeX, Integer sizeY) {

        positions = new ArrayList<>();
        probes = new ArrayList<>();

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

        List<Position> busyPositions = probes.stream()
                .map(probes -> probes.getPosition())
                .collect(Collectors.toList());

        return busyPositions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public List<Position> getFreePositions() {

        List<Position> freePositions = ((List) ((ArrayList) positions).clone());
        freePositions.removeAll(getBusyPositions());

        return freePositions;
    }

    public Integer nextProbeId() {
        return probes.size() + 1;
    }

    public boolean isPositionBusy(Position position) {

        List<Position> busyPositions = getBusyPositions();
        return busyPositions.contains(position);
    }

    public Position nextFreePosition() {

        Position freePosition = new Position(0, 0);

        if (getFreePositions().stream().findFirst().isPresent())
            freePosition = getFreePositions().stream().findFirst().get();

        return freePosition;
    }

    public Optional<Probe> findProbeById(Integer id) {

        Optional<Probe> currentProbe = probes.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        return currentProbe;
    }

    public List<Probe> add(Probe probe) {
        probes.add(probe);
        return probes;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void drawConsoleSurface() {

        logger.info("");

        StringBuilder marsSurface;

        for (Integer posY = SIZE_X - 1; posY > -1; posY--) {

            marsSurface = new StringBuilder();

            for (Integer posX = 0; posX < SIZE_X; posX++) {

                String positionDraw = "====";
                Position currentPosition = new Position(posX, posY);

                for (Probe probeOnSoil : probes) {
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
