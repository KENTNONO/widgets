package test.java.com.worldline.interview.Engine;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.worldline.interview.Engine.Engine;
import com.worldline.interview.Engine.InternalCombustionEngine;
import com.worldline.interview.Fuel.FuelType;

public class InternalComvustionEngineAndEngineUnitTest {
    Engine engine;

    @Test
    public void itShouldCreateAPetrolCombustionEngineWithValidValues() {

        //when
        engine = createEngine(FuelType.PETROL);

        //then
        assertEquals(engine.getFuelType(), FuelType.PETROL);
        assertTrue(engine.getFuelLevel()==0);
        assertEquals(engine.getBatchSize(), 8);
        assertEquals(engine.getFuelType().getValue(), 9.0, 0.1);
        assertFalse(engine.isRunning());
        assertArrayEquals(engine.getAvailabFuelTypes(), new FuelType[]{FuelType.DIESEL, FuelType.PETROL});

    }

    @Test
    public void itShouldCreateADieselCombustionEngineWithValidValues() {

        //when
        engine = createEngine(FuelType.DIESEL);

        //then
        assertEquals(engine.getFuelType(), FuelType.DIESEL);
        assertTrue(engine.getFuelLevel()==0);
        assertEquals(engine.getBatchSize(), 8);
        assertEquals(engine.getFuelType().getValue(), 12.0, 0.1);
        assertFalse(engine.isRunning());
        assertArrayEquals(engine.getAvailabFuelTypes(), new FuelType[]{FuelType.DIESEL, FuelType.PETROL});

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldThrowExpectedExceptionGivenInvalidFlueType() {

        //when
        engine = createEngine(FuelType.COAL);
        
        fail("Test initial engine with the Invalid fuel.");

    }

    @Test
    public void itShouldAllowToFillEngineWithValidFlueType() {
        
        //given
        engine = createEngine(FuelType.DIESEL);
        
        //when
        engine.fill(FuelType.DIESEL, 50);
        
        //then
        assertEquals(engine.getFuelLevel(), 50);

    }

    @Test(expected = IllegalStateException.class)
    public void itShouldThrowExpectedExceptionFillDifferentFlueType() {

        //given
        engine = createEngine(FuelType.DIESEL);

        //when
        engine.fill(FuelType.PETROL, 10);
        
        fail("Test fill engine with different valid fuel.");

    }

    @Test
    public void itShouldAllowToStartTheEngineWhenIsNotEmpty() {

        //given
        engine = createEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 10);

        //when
        engine.start();

        //then
        assertTrue(engine.isRunning());
    } 

    @Test(expected = IllegalStateException.class)
    public void itShouldNotAllowToStartTheEngineWhenIsEmpty() {

        //given
        engine = createEngine(FuelType.PETROL);

        //when
        engine.start();

        fail("Test engine fuel is empty use start");

    }

    @Test
    public void itShouldAllowToStopTheEngineWhenIsRunning() {

        //given
        engine = createEngine(FuelType.PETROL);
        engine.fill(FuelType.PETROL, 10);
        engine.start();

        //when
        engine.stop();
        
        assertFalse(engine.isRunning());


    }



    public Engine createEngine(FuelType fuelType){
        return  new InternalCombustionEngine(fuelType);
    }
    
}
