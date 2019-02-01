package com.elo7.marsexplorerapi.model;

public class Position {

    private Integer X;
    private Integer Y;

    public Position(Integer X, Integer Y) {
        this.X = X;
        this.Y = Y;
    }

    public Integer getX() {
        return X;
    }

    public Integer getY() {
        return Y;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.X.equals(((Position) obj).X)
                && this.Y.equals(((Position) obj).Y));
    }

    public Position getNewPosition(Direction direction) {

        Integer newPosX = X;
        Integer newPosY = Y;

        switch (direction) {
            case W: {
                newPosX = X > 0 ? X - 1 : 0;
                break;
            }
            case S: {
                newPosY = Y > 0 ? Y - 1 : 0;
                break;
            }
            case E: {
                newPosX++;
                break;
            }
            case N: {
                newPosY++;
                break;
            }
        }

        return new Position(newPosX, newPosY);
    }


}