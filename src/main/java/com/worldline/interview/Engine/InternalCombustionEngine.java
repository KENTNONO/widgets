package com.worldline.interview.Engine;

import com.worldline.interview.Fuel.FuelType;

/**
 * The type Internal combustion engine.
 * Base on Engine 
 */
public class InternalCombustionEngine extends Engine {
    private static final int BATCH_SIZE = 8; 
    private static final FuelType[] ENGINE_FUEL_TYPES = {FuelType.DIESEL, FuelType.PETROL};
    
    /**
     * Instantiate a new Internal Combustion Engine.
     *
     * @param fuelType the Fuel Type
     */    
    public InternalCombustionEngine(FuelType requiredFuelType) {
        super(requiredFuelType, BATCH_SIZE, ENGINE_FUEL_TYPES);
    }
}
