package com.worldline.interview.Engine;

import com.worldline.interview.Fuel.FuelType;

/**
 * The type Steam engine.
 * Base on Engine
 */
public class SteamEngine extends Engine {
    private static final int BATCH_SIZE = 2; 
    private static final FuelType[] ENGINE_FUEL_TYPES = {FuelType.COAL, FuelType.WOOD};
    
    /**
     * Instantiate a new Steam Engine.
     *
     * @param fuelType the Fuel Type
     */    
    public SteamEngine (FuelType fuelType) {
        super(fuelType, BATCH_SIZE, ENGINE_FUEL_TYPES);
    }

}
