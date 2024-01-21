package com.eurocars.rest.dto;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.enums.CarStatus;

public class CarDTO {

    private CarStatus carStatus;
    private String id;
    private String make;
    private String model;
    private int mileage;
    private int year;
    private double priceWithTax;

    private String firstImageUrl;

    public CarDTO() {
    }

    public String getFirstImageUrl() {
        return firstImageUrl;
    }

    public void setFirstImageUrl(String firstImageUrl) {
        this.firstImageUrl = firstImageUrl;
    }

    public CarDTO(Car car) {
        this.carStatus=car.getCarStatus();
        this.id = car.getId();
        this.make = car.getMake();
        this.model=car.getModel();
        this.mileage = car.getMileage();
        this.year = car.getYear();
        this.priceWithTax = car.getPriceWithTax();
        if (car.getImageUrls() != null && !car.getImageUrls().isEmpty()) {
            this.firstImageUrl = car.getImageUrls().get(0);
        } else {
            this.firstImageUrl = null; // or set a default image URL if desired
        }
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }
}


