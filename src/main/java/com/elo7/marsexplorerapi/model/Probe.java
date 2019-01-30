package com.elo7.marsexplorerapi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Probe {

    private Integer id;
    private Direction direction;
    private Position position;
    Logger logger = LogManager.getLogger(this);

    public Probe(Integer id, Direction direction, Position position) {
        this.id = id;
        this.direction = direction;
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public Integer getId() {
        return id;
    }

    public void move(List<Probe> landedProbes) {

        Integer newPosX = position.getX();
        Integer newPosY = position.getY();

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

        Position newPosition = new Position(newPosX, newPosY);

        boolean isPositionBusy = false;

        if (landedProbes != null) {
            for (Probe landedProbe : landedProbes) {
                isPositionBusy = landedProbe.position.equals(newPosition);
                if (isPositionBusy) {
                    logger.info("[WARNING] Probe P" + landedProbe.getId() + " is already in this position: posX: " + newPosX + " posY: " + newPosY);
                    return;
                }
            }
        }

        logger.info("Moving probe P" + id + " to new position: posX: " + newPosX + " posY: " + newPosY);
        this.position = newPosition;
    }

    public void spin(ProbeCommand probeCommand) {

        if (probeCommand.equals(ProbeCommand.RIGHT)) {

            switch (direction) {
                case N:
                    direction = Direction.E;
                    break;
                case E:
                    direction = Direction.S;
                    break;
                case S:
                    direction = Direction.W;
                    break;
                case W:
                    direction = Direction.N;
                    break;
            }

            logger.info("Turn probe P" + id + " left... new direction: " + direction);
        }

        if (probeCommand.equals(ProbeCommand.LEFT)) {

            switch (direction) {
                case N:
                    direction = Direction.W;
                    break;
                case E:
                    direction = Direction.N;
                    break;
                case S:
                    direction = Direction.E;
                    break;
                case W:
                    direction = Direction.S;
                    break;
            }

            logger.info("Turn probe P" + id + " right... new direction: " + direction);
        }
    }
}
