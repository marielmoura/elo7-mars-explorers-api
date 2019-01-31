package com.elo7.marsexplorerapi.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Probe {

    private Integer id;
    private Direction direction;
    private Position position;
    private Logger logger = LogManager.getLogger(this);

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

    public Position getNewPosition() {

        Position newPosition = direction.getNewPosition(position.getX(), position.getY());
        logger.info("Moving probe P" + id + " to new position: posX: " + newPosition.getX() + " posY: " + newPosition.getY());
        return newPosition;

    }

    public Direction getNewDirection(ProbeCommand probeCommand) {

        logger.info("Turn probe P" + id + " right... new direction: " + direction);
        return direction.getNewDirection(probeCommand);

    }
}
