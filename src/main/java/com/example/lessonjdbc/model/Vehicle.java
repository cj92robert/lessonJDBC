package com.example.lessonjdbc.model;


public class Vehicle {

    private long vehicleId;
    private String brand;
    private String model;
    private long productionYear;

    public Vehicle() {
    }

    public Vehicle(long vehicleId, String brand, String model, long productionYear) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public long getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(long productionYear) {
        this.productionYear = productionYear;
    }

}
