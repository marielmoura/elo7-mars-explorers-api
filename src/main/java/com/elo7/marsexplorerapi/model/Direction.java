package com.elo7.marsexplorerapi.model;

public enum Direction {
    N {
        public Direction getNewDirection(ProbeCommand command) {
            if (ProbeCommand.R.equals(command)) {
                return E;
            }

            if (ProbeCommand.L.equals(command)) {
                return W;
            }

            return this;
        }
    },
    E {
        public Direction getNewDirection(ProbeCommand command) {

            if (ProbeCommand.R.equals(command)) {
                return S;
            }

            if (ProbeCommand.L.equals(command)) {
                return N;
            }

            return this;
        }
    },
    S {
        public Direction getNewDirection(ProbeCommand command) {
            if (ProbeCommand.R.equals(command)) {
                return W;
            }

            if (ProbeCommand.L.equals(command)) {
                return E;
            }

            return this;
        }
    },
    W {
        public Direction getNewDirection(ProbeCommand command) {
            if (ProbeCommand.R.equals(command)) {
                return N;
            }

            if (ProbeCommand.L.equals(command)) {
                return S;
            }

            return this;
        }
    };

    public abstract Direction getNewDirection(ProbeCommand probeCommand);
}