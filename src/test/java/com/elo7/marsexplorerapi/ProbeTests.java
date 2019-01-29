package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.AxisPosition;
import com.elo7.marsexplorerapi.model.CardinalDirection;
import com.elo7.marsexplorerapi.model.Probe;
import org.junit.Assert;
import org.junit.Test;

public class ProbeTests {

    @Test
    public void move_12N_Returns13N() {
        AxisPosition initialPosition = new AxisPosition(1, 2);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.spinLeft();
        newProbe.move();
        newProbe.spinLeft();
        newProbe.move();
        newProbe.spinLeft();
        newProbe.move();
        newProbe.spinLeft();
        newProbe.move();
        newProbe.move();
        AxisPosition expectedPosition = new AxisPosition(1, 3);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(CardinalDirection.N, newProbe.getDirection());
    }

    @Test
    public void move_33E_Returns51E() {
        AxisPosition initialPosition = new AxisPosition(3, 3);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.move();
        newProbe.move();
        newProbe.spinRight();
        newProbe.move();
        newProbe.move();
        newProbe.spinRight();
        newProbe.move();
        newProbe.spinRight();
        newProbe.spinRight();
        newProbe.move();
        AxisPosition expectedPosition = new AxisPosition(5, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(CardinalDirection.E, newProbe.getDirection());
    }

    @Test
    public void move_00N_Returns01N() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.move();
        AxisPosition expectedPosition = new AxisPosition(0, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00E_Returns10E() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.move();
        AxisPosition expectedPosition = new AxisPosition(1, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00S_Returns00S() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.S, initialPosition);
        newProbe.move();
        AxisPosition expectedPosition = new AxisPosition(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00W_Returns00W() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.W, initialPosition);
        newProbe.move();
        AxisPosition expectedPosition = new AxisPosition(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void spinLeft_N_ReturnsW() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.spinLeft();
        Assert.assertEquals(CardinalDirection.W, newProbe.getDirection());
    }

    @Test
    public void spinLeft_E_ReturnsN() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.spinLeft();
        Assert.assertEquals(CardinalDirection.N, newProbe.getDirection());
    }

    @Test
    public void spinLeft_S_ReturnsE() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.S, initialPosition);
        newProbe.spinLeft();
        Assert.assertEquals(CardinalDirection.E, newProbe.getDirection());
    }

    @Test
    public void spinLeft_W_ReturnsS() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.W, initialPosition);
        newProbe.spinLeft();
        Assert.assertEquals(CardinalDirection.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_N_ReturnsE() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.spinRight();
        Assert.assertEquals(CardinalDirection.E, newProbe.getDirection());
    }

    @Test
    public void spinRight_E_ReturnsS() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.spinRight();
        Assert.assertEquals(CardinalDirection.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_S_ReturnsW() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.S, initialPosition);
        newProbe.spinRight();
        Assert.assertEquals(CardinalDirection.W, newProbe.getDirection());
    }

    @Test
    public void spinRight_W_ReturnsN() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.W, initialPosition);
        newProbe.spinRight();
        Assert.assertEquals(CardinalDirection.N, newProbe.getDirection());
    }

}
