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

    public Probe move(Planet planet) {

        Position newPosition = position.getNewPosition(direction);

        if (planet.isPositionBusy(newPosition)) {
            logger.info("This position is busy: posX: " + newPosition.getX() + " posY: " + newPosition.getY());
            return this;
        }

        position = newPosition;
        logger.info("Moving probe P" + id + " to new position: posX: " + newPosition.getX() + " posY: " + newPosition.getY());
        return this;

    }

    public Probe spin(ProbeCommand probeCommand) {

        direction = direction.getNewDirection(probeCommand);
        logger.info("Turn probe P" + id + " right... new direction: " + direction);
        return this;

    }

    public Probe land(Planet planet) {

        if (!planet.isPositionInAreaRange(position)) {
            position = new Position(0, 0);
        }

        if (planet.isPositionBusy(position)) {
            position = planet.nextFreePosition();
        }

        id = planet.nextProbeId();
        planet.add(this);
        planet.drawConsoleSurface();
        return this;

    }
}
