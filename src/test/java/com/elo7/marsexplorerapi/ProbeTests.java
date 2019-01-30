package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProbeTests {

    @Test
    public void avoidCollisionTest_02S_01S() {
        Probe newProbe11 = new Probe(1, Direction.S, new Position(0, 2));
        Probe newProbe12 = new Probe(2, Direction.N, new Position(0, 0));
        List<Probe> landedProbes = new ArrayList<>();
        landedProbes.add(newProbe11);
        landedProbes.add(newProbe12);
        newProbe11.move(landedProbes);
        newProbe11.move(landedProbes);
        Assert.assertEquals(newProbe11.getPosition(), new Position(0, 1));
    }

    @Test
    public void move_12N_Returns13N() {
        Position initialPosition = new Position(1, 2);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.spin(ProbeCommand.LEFT);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.LEFT);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.LEFT);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.LEFT);
        newProbe.move(new ArrayList<>());
        newProbe.move(new ArrayList<>());
        Position expectedPosition = new Position(1, 3);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

    @Test
    public void move_33E_Returns51E() {
        Position initialPosition = new Position(3, 3);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.move(new ArrayList<>());
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.RIGHT);
        newProbe.move(new ArrayList<>());
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.RIGHT);
        newProbe.move(new ArrayList<>());
        newProbe.spin(ProbeCommand.RIGHT);
        newProbe.spin(ProbeCommand.RIGHT);
        newProbe.move(new ArrayList<>());
        Position expectedPosition = new Position(5, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void move_00N_Returns01N() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.move(new ArrayList<>());
        Position expectedPosition = new Position(0, 1);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00E_Returns10E() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.move(new ArrayList<>());
        Position expectedPosition = new Position(1, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00S_Returns00S() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        newProbe.move(new ArrayList<>());
        Position expectedPosition = new Position(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void move_00W_Returns00W() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        newProbe.move(new ArrayList<>());
        Position expectedPosition = new Position(0, 0);
        Assert.assertEquals(expectedPosition, newProbe.getPosition());
    }

    @Test
    public void spinLeft_N_ReturnsW() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.spin(ProbeCommand.LEFT);
        Assert.assertEquals(Direction.W, newProbe.getDirection());
    }

    @Test
    public void spinLeft_E_ReturnsN() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.spin(ProbeCommand.LEFT);
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

    @Test
    public void spinLeft_S_ReturnsE() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        newProbe.spin(ProbeCommand.LEFT);
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void spinLeft_W_ReturnsS() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        newProbe.spin(ProbeCommand.LEFT);
        Assert.assertEquals(Direction.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_N_ReturnsE() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.N, initialPosition);
        newProbe.spin(ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.E, newProbe.getDirection());
    }

    @Test
    public void spinRight_E_ReturnsS() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.E, initialPosition);
        newProbe.spin(ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.S, newProbe.getDirection());
    }

    @Test
    public void spinRight_S_ReturnsW() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.S, initialPosition);
        newProbe.spin(ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.W, newProbe.getDirection());
    }

    @Test
    public void spinRight_W_ReturnsN() {
        Position initialPosition = new Position(0, 0);
        Probe newProbe = new Probe(1, Direction.W, initialPosition);
        newProbe.spin(ProbeCommand.RIGHT);
        Assert.assertEquals(Direction.N, newProbe.getDirection());
    }

}
