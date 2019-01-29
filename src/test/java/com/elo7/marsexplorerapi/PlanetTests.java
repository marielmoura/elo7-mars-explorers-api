package com.elo7.marsexplorerapi;

import com.elo7.marsexplorerapi.model.Planet;
import org.junit.Assert;
import org.junit.Test;

public class PlanetTests {

    @Test
    public void draw_5_5_Returns25() {
        Planet mars = new Planet(5, 5);
        mars.draw();
        Assert.assertEquals(25, mars.getPositions().size());
    }

}
