package com.worldline.interview.Fuel;

public enum FuelType {
    /**
     * Petrol fuel type.
     */
    PETROL(9.00, "petrol"), 

    /**
     * Diesel fuel type.
     */
    DIESEL(12.00, "diesel"), 
    
    /**
     * Wood fuel type.
     */
    WOOD(4.35, "wood"), 
    
    /**
     * Coal fuel type.
     */
    COAL(5.65, "coal");

    private double costPerBatch;
    private String fuelType;
    private FuelType(double costPerBatch ,String fuelType) {
        this.costPerBatch = costPerBatch;
        this.fuelType = fuelType;
    }

    /**
     * Get value.
     *
     * @return the value
     */
    public double getValue() {
        return costPerBatch;
    }

    /**
     * Get Name.
     *
     * @return name
     */
    public String getName() {
        return fuelType;
    }
}
