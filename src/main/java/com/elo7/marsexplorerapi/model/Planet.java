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

    public void draw() {

        for (int posY = 0; posY < this.getSizeY(); posY++) {

            StringBuilder marsSurfaceLine = new StringBuilder();

            for (int posX = 0; posX < this.getSizeX(); posX++) {

                String positionDraw = "===";
                AxisPosition currentPosition = new AxisPosition(posX, posY);

                if (this.exploredPositions.contains(currentPosition)) {
                    positionDraw = "XXX";
                }

//                for (Probe probeOnSoil : probesOnSoil) {
//                    if (currentPosition.equals(probeOnSoil.getPosition())) {
//                        positionDraw = probeOnSoil.getId() + probeOnSoil.getDirection();
//                        continue;
//                    }
//                }

                marsSurfaceLine.append(positionDraw);
            }

            System.out.println("Y" + posY + " " + marsSurfaceLine);
        }

        System.out.println("");
    }

}
