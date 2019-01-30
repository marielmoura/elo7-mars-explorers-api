package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProbeTests {

    @Test
    public void avoidCollisionTest_02S_01S() {
        Probe newProbe11 = new Probe(1, CardinalDirection.S, new AxisPosition(0, 2));
        Probe newProbe12 = new Probe(2, CardinalDirection.N, new AxisPosition(0, 0));
        List<Probe> landedProbes = new ArrayList<>();
        landedProbes.add(newProbe11);
        landedProbes.add(newProbe12);
        newProbe11.move(landedProbes);
        newProbe11.move(landedProbes);
        Assert.assertEquals(newProbe11.getPosition(), new AxisPosition(0, 1));
    }

    @Test
    public void move_12N_Returns13N() {
        AxisPosition initialPosition = new AxisPosition(1, 2);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.spin(ProbeCommand.Left);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.Left);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.Left);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.Left);
        newProbe.move(new ArrayList<>());
        newProbe.move(new ArrayList<>());
        AxisPosition expectedPosition = new AxisPosition(1, 3);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(CardinalDirection.N, newProbe.getDirection());
    }

    @Test
    public void move_33E_Returns51E() {
        AxisPosition initialPosition = new AxisPosition(3, 3);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.move(new ArrayList<>());
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.Right);
        newProbe.move(new ArrayList<>());
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.Right);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.Right);
        newProbe.spin(ProbeCommand.Right);
        newProbe.move(new ArrayList<>());
        AxisPosition expectedPosition = new AxisPosition(5, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(CardinalDirection.E, newProbe.getDirection());
    }

    @Test
    public void move_00N_Returns01N() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.move(new ArrayList<>());
        AxisPosition expectedPosition = new AxisPosition(0, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00E_Returns10E() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.move(new ArrayList<>());
        AxisPosition expectedPosition = new AxisPosition(1, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00S_Returns00S() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.S, initialPosition);
        newProbe.move(new ArrayList<>());
        AxisPosition expectedPosition = new AxisPosition(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00W_Returns00W() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.W, initialPosition);
        newProbe.move(new ArrayList<>());
        AxisPosition expectedPosition = new AxisPosition(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void spinLeft_N_ReturnsW() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.spin(ProbeCommand.Left);
        Assert.assertEquals(CardinalDirection.W, newProbe.getDirection());
    }

    @Test
    public void spinLeft_E_ReturnsN() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.spin(ProbeCommand.Left);
        Assert.assertEquals(CardinalDirection.N, newProbe.getDirection());
    }

    @Test
    public void spinLeft_S_ReturnsE() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.S, initialPosition);
        newProbe.spin(ProbeCommand.Left);
        Assert.assertEquals(CardinalDirection.E, newProbe.getDirection());
    }

    @Test
    public void spinLeft_W_ReturnsS() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.W, initialPosition);
        newProbe.spin(ProbeCommand.Left);
        Assert.assertEquals(CardinalDirection.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_N_ReturnsE() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.N, initialPosition);
        newProbe.spin(ProbeCommand.Right);
        Assert.assertEquals(CardinalDirection.E, newProbe.getDirection());
    }

    @Test
    public void spinRight_E_ReturnsS() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.E, initialPosition);
        newProbe.spin(ProbeCommand.Right);
        Assert.assertEquals(CardinalDirection.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_S_ReturnsW() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.S, initialPosition);
        newProbe.spin(ProbeCommand.Right);
        Assert.assertEquals(CardinalDirection.W, newProbe.getDirection());
    }

    @Test
    public void spinRight_W_ReturnsN() {
        AxisPosition initialPosition = new AxisPosition(0, 0);
        Probe newProbe = new Probe(1, CardinalDirection.W, initialPosition);
        newProbe.spin(ProbeCommand.Right);
        Assert.assertEquals(CardinalDirection.N, newProbe.getDirection());
    }

}
