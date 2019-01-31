package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.*;
import org.junit.Assert;
import org.junit.Test;

public class ProbeTests {

    @Test
    public void avoidProbeLandingOverAnotherProbe_P200N_ReturnsP210N() {
        Planet mars = new Planet(5, 5);
        Probe newProbe11 = new Probe(1, Direction.N, new Position(0, 0));
        mars.landProbe(newProbe11);
        Probe newProbe12 = new Probe(2, Direction.N, new Position(0, 0));
        newProbe12 = mars.landProbe(newProbe12);
        Assert.assertEquals(new Position(1,0), newProbe12.getPosition());
    }

    @Test
    public void avoidCollisionBetweenTwoProbes_P100N_ReturnsP100N() {
        Planet mars = new Planet(5, 5);
        Probe newProbe11 = new Probe(1, Direction.E, new Position(0, 0));
        mars.landProbe(newProbe11);
        Probe newProbe12 = new Probe(2, Direction.N, new Position(1, 0));
        mars.landProbe(newProbe12);
        newProbe11 = mars.moveProbe(1);
        Assert.assertEquals(newProbe11.getPosition(), new Position(0, 0));
    }

    @Test
    public void move_12N_Returns13N() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(1, 2);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        mars.landProbe(newProbe);
        mars.spinProbe(1, ProbeCommand.LEFT);
        mars.moveProbe(1);
        mars.spinProbe(1, ProbeCommand.LEFT);
        mars.moveProbe(1);
        mars.spinProbe(1, ProbeCommand.LEFT);
        mars.moveProbe(1);
        mars.spinProbe(1, ProbeCommand.LEFT);
        mars.moveProbe(1);
        newProbe = mars.moveProbe(1);
        Position expectedPosition = new Position(1, 3);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

    @Test
    public void move_33E_Returns51E() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(3, 3);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        mars.landProbe(newProbe);
        mars.moveProbe(1);
        mars.moveProbe(1);
        mars.spinProbe(1, ProbeCommand.RIGHT);
        mars.moveProbe(1);
        mars.moveProbe(1);
        mars.spinProbe(1, ProbeCommand.RIGHT);
        mars.moveProbe(1);
        mars.spinProbe(1, ProbeCommand.RIGHT);
        mars.spinProbe(1, ProbeCommand.RIGHT);
        newProbe = mars.moveProbe(1);
        Position expectedPosition = new Position(5, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void move_00N_Returns01N() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.moveProbe(1);
        Position expectedPosition = new Position(0, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00E_Returns10E() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.moveProbe(1);
        Position expectedPosition = new Position(1, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00S_Returns00S() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.moveProbe(1);
        Position expectedPosition = new Position(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00W_Returns00W() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.moveProbe(1);
        Position expectedPosition = new Position(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void spinLeft_N_ReturnsW() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.LEFT);
        Assert.assertEquals(Direction.W, newProbe.getDirection());
    }

    @Test
    public void spinLeft_E_ReturnsN() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.LEFT);
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

    @Test
    public void spinLeft_S_ReturnsE() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.LEFT);
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void spinLeft_W_ReturnsS() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.LEFT);
        Assert.assertEquals(Direction.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_N_ReturnsE() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void spinRight_E_ReturnsS() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_S_ReturnsW() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.W, newProbe.getDirection());
    }

    @Test
    public void spinRight_W_ReturnsN() {
        Planet mars = new Planet(5, 5);
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        mars.landProbe(newProbe);
        newProbe = mars.spinProbe(1, ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

}
