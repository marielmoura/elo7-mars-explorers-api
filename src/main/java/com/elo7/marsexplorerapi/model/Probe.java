package com.elo7.marsexplorerapi.model;

import java.util.List;

public class Probe {

    private Integer id;
    private CardinalDirection direction;
    private AxisPosition position;

    public Probe(Integer id, CardinalDirection direction, AxisPosition position) {
        this.id = id;
        this.direction = direction;
        this.position = position;
    }

    public CardinalDirection getDirection() {
        return direction;
    }

    public AxisPosition getPosition() {
        return position;
    }

    public Integer getId() {
        return id;
    }

    public void move(List<Probe> landedProbes) {

        Integer newPosX = position.getPosX();
        Integer newPosY = position.getPosY();

        switch (direction) {
            case S:
                newPosY = newPosY > 0 ? newPosY - 1 : 0;
                break;
            case E:
                newPosX++;
                break;
            case N:
                newPosY++;
                break;
            case W:
                newPosX = newPosX > 0 ? newPosX - 1 : 0;
                break;
        }

        AxisPosition newPosition = new AxisPosition(newPosX, newPosY);

        boolean isPositionBusy = false;

        for (Probe landedProbe : landedProbes) {
            isPositionBusy = landedProbe.position.equals(newPosition);
            if (isPositionBusy) {
                System.out.println("[WARNING] Probe P" + landedProbe.getId() + " is already in this position: posX: " + newPosX + " posY: " + newPosY);
                return;
            }
        }

        System.out.println("Moving probe P" + id + " to new position: posX: " + newPosX + " posY: " + newPosY);
        this.position = newPosition;
    }

    public void spin(ProbeCommand probeCommand) {

        if (probeCommand.equals(ProbeCommand.Right)) {

            switch (direction) {
                case N:
                    direction = CardinalDirection.E;
                    break;
                case E:
                    direction = CardinalDirection.S;
                    break;
                case S:
                    direction = CardinalDirection.W;
                    break;
                case W:
                    direction = CardinalDirection.N;
                    break;
            }

            System.out.println("Turn probe P" + id + " left... new direction: " + direction);
        }

        if (probeCommand.equals(ProbeCommand.Left)) {

            switch (direction) {
                case N:
                    direction = CardinalDirection.W;
                    break;
                case E:
                    direction = CardinalDirection.N;
                    break;
                case S:
                    direction = CardinalDirection.E;
                    break;
                case W:
                    direction = CardinalDirection.S;
                    break;
            }

            System.out.println("Turn probe P" + id + " right... new direction: " + direction);
        }
    }
}
