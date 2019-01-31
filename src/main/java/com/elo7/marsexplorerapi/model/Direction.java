package com.elo7.marsexplorerapi.model;

public enum Direction {
    N {
        public Position getNewPosition(Integer posX, Integer posY) {
            posY++;
            return new Position(posX, posY);
        }

        public Direction getNewDirection(ProbeCommand command) {
            if (ProbeCommand.RIGHT.equals(command)) {
                return E;
            }

            if (ProbeCommand.LEFT.equals(command)) {
                return W;
            }

            return this;
        }
    },
    E {
        public Position getNewPosition(Integer posX, Integer posY) {
            posX++;
            return new Position(posX, posY);
        }

        public Direction getNewDirection(ProbeCommand command) {

            if (ProbeCommand.RIGHT.equals(command)) {
                return S;
            }

            if (ProbeCommand.LEFT.equals(command)) {
                return N;
            }

            return this;
        }
    },
    S {
        public Position getNewPosition(Integer posX, Integer posY) {
            posY = posY > 0 ? posY - 1 : 0;
            return new Position(posX, posY);
        }

        public Direction getNewDirection(ProbeCommand command) {
            if (ProbeCommand.RIGHT.equals(command)) {
                return W;
            }

            if (ProbeCommand.LEFT.equals(command)) {
                return E;
            }

            return this;
        }
    },
    W {
        public Position getNewPosition(Integer posX, Integer posY) {
            posX = posX > 0 ? posX - 1 : 0;
            return new Position(posX, posY);
        }

        public Direction getNewDirection(ProbeCommand command) {
            if (ProbeCommand.RIGHT.equals(command)) {
                return N;
            }

            if (ProbeCommand.LEFT.equals(command)) {
                return S;
            }

            return this;
        }
    };

    public abstract Position getNewPosition(Integer posX, Integer posY);
    public abstract Direction getNewDirection(ProbeCommand probeCommand);
}