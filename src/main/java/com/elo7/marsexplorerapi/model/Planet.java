package com.elo7.marsexplorerapi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Planet {

    public static Planet mars = new Planet(5, 5);

    private Integer sizeX;
    private Integer sizeY;
    private List<Position> positions;
    private List<Position> exploredPositions;
    private List<Position> unexploredPositions;
    private Double exploredPercentage;
    private static List<Probe> landedProbes;

    Logger logger = LogManager.getLogger(this);

    public Planet(Integer sizeX, Integer sizeY) {

        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.positions = new ArrayList<>();
        this.exploredPositions = new ArrayList<>();
        this.unexploredPositions = new ArrayList<>();
        this.landedProbes = new ArrayList<>();
        this.exploredPercentage = 0.0;

        for (int posY = 0; posY < sizeY; posY++) {
            for (int posX = 0; posX < sizeX; posX++) {
                Position planetPosition = new Position(posX, posY);
                positions.add(planetPosition);
                unexploredPositions.add(planetPosition);
            }
        }
    }

    public List<Position> getPositions() {
        return positions;
    }

    public boolean isPositionInAreaRange(Position position) {
        return positions.contains(position);
    }

    public boolean isPositionExplored(Position position) {
        return exploredPositions.contains(position);
    }

    public Position nextFreePosition() {

        Position unexploredPosition = new Position(0, 0);

        if (unexploredPositions.size() > 0)
            unexploredPosition = unexploredPositions.stream().findFirst().get();

        return unexploredPosition;
    }

    private void updateExploredPositions() {

        for (Probe probe : landedProbes) {
            if (!exploredPositions.contains(probe.getPosition()))
                exploredPositions.add(probe.getPosition());
        }

        exploredPercentage = ((double) exploredPositions.size() / (double) positions.size()) * 100;
        unexploredPositions.removeAll(exploredPositions);
    }

    public void setLandedProbes(List<Probe> landedProbes) {

        this.landedProbes = landedProbes;
        updateExploredPositions();
        toString();

    }

    public static String addProbe(Probe newProbe) {

        Position landingPosition = newProbe.getPosition();

        if (!Planet.mars.isPositionInAreaRange(landingPosition)) {
            return "Landing position out of area range!";
        }

        if (Planet.mars.isPositionExplored(landingPosition)) {
            landingPosition = Planet.mars.nextFreePosition();
        }

        Integer id = landedProbes.size() + 1;
        Probe _newProbe = new Probe(id, newProbe.getDirection(), landingPosition);
        landedProbes.add(_newProbe);
        Planet.mars.setLandedProbes(landedProbes);

        return "Probe P" + _newProbe.getId() + " landed successfully!";
    }

    public static Optional<Probe> findProbeById(Integer id) {

        Optional<Probe> currentProbe = landedProbes.stream()
                .filter(probe -> probe.getId() == id).findFirst();

        return currentProbe;
    }

    public static void saveProbe(Probe probe, ProbeCommand probeCommand) {
        landedProbes.remove(probe);

        if (!probeCommand.equals(ProbeCommand.MOVE)) {
            probe.spin(probeCommand);
        }

        if (probeCommand.equals(ProbeCommand.MOVE)) {
            probe.move(landedProbes);
        }

        landedProbes.add(probe);
        Planet.mars.setLandedProbes(landedProbes);
    }

    public static List<Probe> getLandedProbes() {
        return landedProbes;
    }

    public void drawSurface() {

        this.toString();

//        logger.info(this.toString());

    }

    @Override
    public String toString() {

        logger.info("");
        logger.info("Explored surface: " + exploredPercentage + "%");

        StringBuilder marsSurface = new StringBuilder();

        for (Integer posY = sizeX - 1; posY > -1; posY--) {

            marsSurface = new StringBuilder();

            for (Integer posX = 0; posX < sizeX; posX++) {

                String positionDraw = "====";
                Position currentPosition = new Position(posX, posY);

                if (exploredPositions.contains(currentPosition)) {
                    positionDraw = "XXXX";
                }

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

        return marsSurface.toString();
    }

}
