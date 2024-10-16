package test.java.com.worldline.interview.Engine;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.worldline.interview.Engine.Engine;
import com.worldline.interview.Engine.SteamEngine;
import com.worldline.interview.Fuel.FuelType;

public class SteamEngineUnitTest {
    Engine engine;

    @Test
    public void itShouldCreateCoalSteamWithValidValues() {

        //when
        engine = createEngine(FuelType.COAL);

        //then
        assertEquals(engine.getFuelType(), FuelType.COAL);
        assertTrue(engine.getFuelLevel()==0);
        assertEquals(engine.getBatchSize(), 2);
        assertEquals(engine.getFuelType().getValue(), 5.65, 0.1);
        assertFalse(engine.isRunning());
        assertArrayEquals(engine.getAvailabFuelTypes(), new FuelType[]{FuelType.COAL, FuelType.WOOD});

    }

    @Test
    public void itShouldCreateAWoodSteamEngineWithValidValues() {

        //when
        engine = createEngine(FuelType.WOOD);

        //then
        assertEquals(engine.getFuelType(), FuelType.WOOD);
        assertTrue(engine.getFuelLevel()==0);
        assertEquals(engine.getBatchSize(), 2);
        assertEquals(engine.getFuelType().getValue(), 4.35, 0.1);
        assertFalse(engine.isRunning());
        assertArrayEquals(engine.getAvailabFuelTypes(), new FuelType[]{FuelType.COAL, FuelType.WOOD});

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldThrowExpectedExceptionGivenInvalidFlueType() {

        //when
        engine = createEngine(FuelType.PETROL);
        
        fail("Test initial engine with the Invalid fuel.");

    }
    
    public Engine createEngine(FuelType fuelType){
        return  new SteamEngine(fuelType);
    }
}