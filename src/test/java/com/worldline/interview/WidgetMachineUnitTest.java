package test.java.com.worldline.interview;

import static org.junit.Assert.*;
import org.junit.Test;

import com.worldline.interview.WidgetMachine;
import com.worldline.interview.Engine.Engine;
import com.worldline.interview.Engine.InternalCombustionEngine;
import com.worldline.interview.Engine.SteamEngine;
import com.worldline.interview.Fuel.FuelType;


public class WidgetMachineUnitTest{
    WidgetMachine widgetMachine;
    @Test
    public void itShouldReturnTheExpectedValueWhenUsingUsingInternalCombustionEngineAndPetrolFuel() {

        Engine engine = createCombustionEngineAndFill(FuelType.PETROL, 50);
        
        widgetMachine = new WidgetMachine(engine);

        double totalCost = widgetMachine.produceWidgets(2);

        assertEquals(totalCost, 9.0,0.1);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingInternalCombustionEngineAndDieselFuel() {

        Engine engine = createCombustionEngineAndFill(FuelType.DIESEL, 100);

        widgetMachine = new WidgetMachine(engine);

        double totalCost = widgetMachine.produceWidgets(50);

        assertEquals(totalCost, 84.0,0.1);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingSteamEngineAndWoodFuel() {

        Engine engine = createSteamEngineAndFill(FuelType.WOOD, 25);

        widgetMachine = new WidgetMachine(engine);

        double totalCost = widgetMachine.produceWidgets(30);

        assertEquals(totalCost, 65.25,0.1);
    }

    @Test
    public void itShouldReturnTheExpectedValueWhenUsingSteamEngineAndCoalFuel() {

        Engine engine = createSteamEngineAndFill(FuelType.COAL, 75);

        widgetMachine = new WidgetMachine(engine);

        double totalCost = widgetMachine.produceWidgets(80);

        assertEquals(totalCost, 226.0,0.1);
    }

    public Engine createCombustionEngineAndFill(FuelType fuelType ,int fuelLevel){
        Engine engine = new InternalCombustionEngine(fuelType);
        engine.fill(fuelType, fuelLevel);
        return engine;
    }
    
    public Engine createSteamEngineAndFill(FuelType fuelType ,int fuelLevel){
        Engine engine = new SteamEngine(fuelType);
        engine.fill(fuelType, fuelLevel);
        return engine;
    }

}