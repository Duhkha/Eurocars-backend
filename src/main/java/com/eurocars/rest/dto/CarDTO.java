package com.eurocars.rest.dto;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.enums.CarStatus;

public class CarDTO {

    private CarStatus carStatus;
    private String id;
    private String name;
    private int mileage;
    private int year;
    private double price;

    public CarDTO() {
    }

    public CarDTO(Car car) {
        this.carStatus=car.getCarStatus();
        this.id = car.getId();
        this.name = car.getMake() + " " + car.getModel();
        this.mileage = car.getMileage();
        this.year = car.getYear();
        this.price = car.getPriceWithTax();
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


