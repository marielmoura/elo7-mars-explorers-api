package com.elo7.marsexplorerapi.model;

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

    public void move(){

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

        System.out.println("Move... posX: " + newPosX + " posY: " + newPosY);

        this.position = newPosition;

    }

    public void spinRight(){

        CardinalDirection newDirection = direction;

        switch (direction) {
            case N:
                newDirection = CardinalDirection.E;
                break;
            case E:
                newDirection = CardinalDirection.S;
                break;
            case S:
                newDirection = CardinalDirection.W;
                break;
            case W:
                newDirection = CardinalDirection.N;
                break;
        }

        System.out.println("Turn probe right... new direction: " + newDirection);

        direction = newDirection;

    };

    public void spinLeft(){

        CardinalDirection newDirection = direction;

        switch (direction) {
            case N:
                newDirection = CardinalDirection.W;
                break;
            case E:
                newDirection = CardinalDirection.N;
                break;
            case S:
                newDirection = CardinalDirection.E;
                break;
            case W:
                newDirection = CardinalDirection.S;
                break;
        }

        System.out.println("Turn probe left... new direction: " + newDirection);

        direction = newDirection;

    };
}
