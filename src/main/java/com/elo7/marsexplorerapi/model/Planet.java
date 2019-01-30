package com.elo7.marsexplorerapi.model;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    private Integer sizeX;
    private Integer sizeY;
    private List<AxisPosition> positions;
    private List<AxisPosition> exploredPositions;
    private List<Probe> probesLanded;

    public Planet(Integer sizeX, Integer sizeY, List<Probe> probesLanded) {

        this.sizeX = sizeY;
        this.sizeY = sizeY;
        this.positions = new ArrayList<>();
        this.exploredPositions = new ArrayList<>();
        this.probesLanded = probesLanded;

        for (Probe probe : probesLanded) {
            exploredPositions.add(probe.getPosition());
        }
    }

    public Planet(Integer sizeX, Integer sizeY) {

        this.sizeX = sizeY;
        this.sizeY = sizeY;
        this.positions = new ArrayList<>();
        this.exploredPositions = new ArrayList<>();
        this.probesLanded = new ArrayList<>();

        for (int posY = 0; posY < sizeY; posY++) {
            for (int posX = 0; posX < sizeX; posX++) {
                AxisPosition planetPosition = new AxisPosition(posX, posY);
                positions.add(planetPosition);
            }
        }
    }

    public List<AxisPosition> getPositions() {
        return positions;
    }

    public Integer getSizeX() {
        return sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public List<AxisPosition> getExploredPositions() {
        return exploredPositions;
    }

    public List<Probe> getProbesLanded() {
        return probesLanded;
    }

    public void setProbesLanded(List<Probe> probesLanded) {
        this.probesLanded = probesLanded;

        for (Probe probe : probesLanded) {
            exploredPositions.add(probe.getPosition());
        }

        draw();
    }

    public void draw() {

        System.out.println("");

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
