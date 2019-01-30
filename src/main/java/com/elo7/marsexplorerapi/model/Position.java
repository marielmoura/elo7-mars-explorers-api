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

}