package com.worldline.interview.Engine;

import java.util.Arrays;

import com.worldline.interview.Fuel.FuelType;

public abstract class Engine {

    private boolean running;
    private int fuelLevel;
    private final FuelType requiredFuelType;
    private final int batchSize;   
    private final FuelType[] engineFuelTypes;

    /**
     * Instantiate a new  Engine.
     *
     * @param requiredFuelType the Fuel Type
     * @param batchSize the batch size
     * @param engineFuelTypes the engine FuelTypes
     */ 
    public Engine(FuelType requiredFuelType, int batchSize, FuelType[] engineFuelTypes){
        this.engineFuelTypes = engineFuelTypes;
        
        if (isFuelAvailable(requiredFuelType)){
            this.requiredFuelType = requiredFuelType;
            this.batchSize = batchSize; 
            running = false;
            fuelLevel = 0;
        } else {
            throw new IllegalStateException(String.format("This engine doesn't support %s fuel.", requiredFuelType.getName()));
        }
    }
    /**
     * Start.
     */
    public void start() {
        if (fuelLevel > 0) {
            running = true;
        } else {
            throw new IllegalStateException("Not able to start engine.");
        }
    }
    /**
     * Stop.
     */
    public void stop() {
        running = false;
    }
    /**
     * is running.
     * 
     * @return boolean
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * fill.
     * 
     * @param fuelType the Fuel Type
     * @param fuelLevel the fuel level
     */
    public void fill(FuelType fuelType, int fuelLevel) {
        if (!fuelType.equals(requiredFuelType)){
            throw new IllegalStateException(String.format("Please fill %s fuel", requiredFuelType.getName()));
        } else {
            if (fuelLevel >= 0 && fuelLevel <= 100) {
                this.fuelLevel = fuelLevel;
            }
            else if (fuelLevel > 100) {
                this.fuelLevel = 100;
            }
            else {
                this.fuelLevel = 0;
            }
        }
    }

    /**
     * Check fuel is available.
     * 
     * @param fuelType the Fuel Type
     * 
     * @return boolean
     */ 
    public boolean isFuelAvailable(FuelType fuelType){
        return Arrays.asList(engineFuelTypes).contains(fuelType);
    }

    /**
     * get engine available FlueTypes.
     * 
     * @return FuelType[]
     */ 
    public FuelType[] getAvailabFuelTypes(){
        return engineFuelTypes;
    }

    /**
     * get engine immediately FlueType.
     * 
     * @return FuelType
     */ 
    public FuelType getFuelType() {
        return  requiredFuelType;
    }

    /**
     * get engine immediately FlueType.
     * 
     * @return FuelType
     */ 
    public int getBatchSize() {
        return batchSize;
    }

    /**
     * get fuel level .
     * 
     * @return fuelLevel
     */ 
    public int getFuelLevel() {
        return fuelLevel;
    }
}
