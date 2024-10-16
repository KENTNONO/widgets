package com.worldline.interview;


import com.worldline.interview.Engine.Engine;

public class WidgetMachine {
    private final Engine engine;

    /**
     * Instantiate a new Widget machine.
     *
     * @param engine the engine
     */    
    public WidgetMachine(Engine engine){
        this.engine = engine;
    }

    public double produceWidgets(int quantity) {
        engine.start();
        double cost = 0;

        if (engine.isRunning()) {
            cost = produce(quantity);
        }

        engine.stop();

        return cost;
    }

    private double produce(int quantity) {
        int batch = 0;
        int batchCount = 0;
        int batchSize = engine.getBatchSize(); 
        double costPerBatch = engine.getFuelType().getValue();
        while (batch < quantity) {
            batch = batch + batchSize;
            batchCount++;
        }

        return batchCount * costPerBatch;
    }


}
