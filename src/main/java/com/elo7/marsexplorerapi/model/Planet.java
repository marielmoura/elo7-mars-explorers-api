package com.elo7.marsexplorerapi.model;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private Integer sizeX;
    private Integer sizeY;
    private List<AxisPosition> positions;
    private List<AxisPosition> exploredPositions;
    private List<AxisPosition> unexploredPositions;
    private Double exploredPercentage;
    private List<Probe> probesLanded;

    public Planet(Integer sizeX, Integer sizeY) {

        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.positions = new ArrayList<>();
        this.exploredPositions = new ArrayList<>();
        this.unexploredPositions = new ArrayList<>();
        this.probesLanded = new ArrayList<>();
        this.exploredPercentage = 0.0;

        for (int posY = 0; posY < sizeY; posY++) {
            for (int posX = 0; posX < sizeX; posX++) {
                AxisPosition planetPosition = new AxisPosition(posX, posY);
                positions.add(planetPosition);
                unexploredPositions.add(planetPosition);
            }
        }
    }

    public List<AxisPosition> getPositions() {
        return positions;
    }

    public boolean isPositionInAreaRange(AxisPosition position) {
        return positions.contains(position);
    }

    public boolean isPositionExplored(AxisPosition position) {
        return exploredPositions.contains(position);
    }

    public AxisPosition nextFreePosition() {

        AxisPosition unexploredPosition = new AxisPosition(0, 0);

        if (unexploredPositions.size() > 0)
            unexploredPosition = unexploredPositions.stream().findFirst().get();

        return unexploredPosition;
    }

    private void updateExploredPositions() {

        for (Probe probe : probesLanded) {
            if (!exploredPositions.contains(probe.getPosition()))
                exploredPositions.add(probe.getPosition());
        }

        exploredPercentage = ((double) exploredPositions.size() / (double) positions.size()) * 100;
        unexploredPositions.removeAll(exploredPositions);
    }

    public void setProbesLanded(List<Probe> probesLanded) {

        this.probesLanded = probesLanded;
        updateExploredPositions();
        drawSurface();

    }

    public void drawSurface() {

        System.out.println("");
        System.out.println("Explored surface: " + exploredPercentage + "%");

        for (Integer posY = sizeX - 1; posY > -1; posY--) {

            StringBuilder marsSurfaceLine = new StringBuilder();

            for (Integer posX = 0; posX < sizeX; posX++) {

                String positionDraw = "====";
                AxisPosition currentPosition = new AxisPosition(posX, posY);

                if (exploredPositions.contains(currentPosition)) {
                    positionDraw = "XXXX";
                }

                for (Probe probeOnSoil : probesLanded) {
                    if (currentPosition.equals(probeOnSoil.getPosition())) {
                        positionDraw = "P" + String.format("%02d", probeOnSoil.getId()) + probeOnSoil.getDirection();
                        continue;
                    }
                }

                marsSurfaceLine.append(positionDraw);
            }

            System.out.println("Y" + posY + " " + marsSurfaceLine);
        }

        System.out.println("");
    }

}
