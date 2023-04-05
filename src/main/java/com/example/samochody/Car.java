package com.example.samochody;

import java.time.LocalDate;

public class Car {

    private long id;
    private String model;

    private  String color;

    private LocalDate productionYear;

    public Car() {
    }

    public Car(long id, String model, String color ,LocalDate productionYear) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.productionYear = productionYear;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionYear() {
        return this.productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
