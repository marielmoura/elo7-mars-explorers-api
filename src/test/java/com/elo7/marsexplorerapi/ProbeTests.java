package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ProbeTests {

    @Test
    public void avoidProbeLandingOverAnotherProbe_P2_00N_Returns_P2_10N() {
        Planet mars = new Planet(5, 5);
        Probe newProbe1 = new Probe(1, Direction.N, new Position(0, 0));
        newProbe1.land(mars);
        Probe newProbe2 = new Probe(2, Direction.N, new Position(0, 0));
        newProbe2.land(mars);
        Assert.assertEquals(new Position(1, 0), newProbe2.getPosition());
    }

    @Test
    public void avoidCollisionBetweenTwoProbes_P1_00N_Returns_P1_00N() {
        Planet mars = new Planet(5, 5);
        Probe newProbe1 = new Probe(1, Direction.E, new Position(0, 0));
        newProbe1 = newProbe1.land(mars);
        Probe newProbe2 = new Probe(2, Direction.N, new Position(1, 0));
        newProbe2.land(mars);
        newProbe1 = newProbe1.move(mars);
        Assert.assertEquals(newProbe1.getPosition(), new Position(0, 0));
    }

    @Test
    public void move_12N_Returns13N() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(1, 2);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.L);
        newProbe.move(mars);
        newProbe.spin(ProbeCommand.L);
        newProbe.move(mars);
        newProbe.spin(ProbeCommand.L);
        newProbe.move(mars);
        newProbe.spin(ProbeCommand.L);
        newProbe.move(mars);
        newProbe.move(mars);
        Position expectedPosition = new Position(1, 3);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

    @Test
    public void move_33E_Returns51E() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(3, 3);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.land(mars);
        newProbe.move(mars);
        newProbe.move(mars);
        newProbe.spin(ProbeCommand.R);
        newProbe.move(mars);
        newProbe.move(mars);
        newProbe.spin(ProbeCommand.R);
        newProbe.move(mars);
        newProbe.spin(ProbeCommand.R);
        newProbe.spin(ProbeCommand.R);
        newProbe.move(mars);
        Position expectedPosition = new Position(5, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void move_00N_Returns01N() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.land(mars);
        newProbe.move(mars);
        Position expectedPosition = new Position(0, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00E_Returns10E() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.land(mars);
        newProbe.move(mars);
        Position expectedPosition = new Position(1, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00S_Returns00S() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        newProbe.land(mars);
        newProbe.move(mars);
        Position expectedPosition = new Position(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00W_Returns00W() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        newProbe.land(mars);
        newProbe.move(mars);
        Position expectedPosition = new Position(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void spinLeft_N_ReturnsW() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.L);
        Assert.assertEquals(Direction.W, newProbe.getDirection());
    }

    @Test
    public void spinLeft_E_ReturnsN() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.L);
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

    @Test
    public void spinLeft_S_ReturnsE() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.L);
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void spinLeft_W_ReturnsS() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.L);
        Assert.assertEquals(Direction.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_N_ReturnsE() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.R);
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void spinRight_E_ReturnsS() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.R);
        Assert.assertEquals(Direction.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_S_ReturnsW() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.R);
        Assert.assertEquals(Direction.W, newProbe.getDirection());
    }

    @Test
    public void spinRight_W_ReturnsN() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        newProbe.land(mars);
        newProbe.spin(ProbeCommand.R);
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

}
