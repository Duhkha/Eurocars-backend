package com.eurocars.rest.dto;

import com.eurocars.core.model.Car;

import java.util.List;
import java.util.Map;

public class CarRequestDTO {
    private String make;
    private String model;
    private Integer year;
    private Integer mileage;
    private Integer priceWithTax;
    private Integer priceWithoutTax;
    private String motor;
    private String motorCapacity;
    private String fuel;
    private String motorStrength;
    private String emissionStandard;
    private String drivetrain;
    private String countryOfOrigin;
    private String transmission;
    private String bodyStyle;
    private String carColor;
    private String numCarDoors;
    private String numCarSeats;
    private String fuelEconomy;
    private String registration;
    private String shortNote;
    private String longNote;
    private List<String> imageUrls;
    private Map<String, List<String>> specifications;


    public Car toEntity() {
        Car car = new Car();
        car.setMake(make);
        car.setModel(model);
        car.setYear(year);
        car.setMileage(mileage);
        car.setPriceWithTax(priceWithTax);
        car.setPriceWithoutTax(priceWithoutTax);
        car.setMotor(motor);
        car.setMotorCapacity(motorCapacity);
        car.setFuel(fuel);
        car.setMotorStrength(motorStrength);
        car.setEmissionStandard(emissionStandard);
        car.setDrivetrain(drivetrain);
        car.setCountryOfOrigin(countryOfOrigin);
        car.setTransmission(transmission);
        car.setBodyStyle(bodyStyle);
        car.setCarColor(carColor);
        car.setNumCarDoors(numCarDoors);
        car.setNumCarSeats(numCarSeats);
        car.setFuelEconomy(fuelEconomy);
        car.setRegistration(registration);
        car.setShortNote(shortNote);
        car.setLongNote(longNote);
        car.setImageUrls(imageUrls);
        car.setSpecifications(specifications);

        return car;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(Integer priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    public Integer getPriceWithoutTax() {
        return priceWithoutTax;
    }

    public void setPriceWithoutTax(Integer priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getMotorCapacity() {
        return motorCapacity;
    }

    public void setMotorCapacity(String motorCapacity) {
        this.motorCapacity = motorCapacity;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getMotorStrength() {
        return motorStrength;
    }

    public void setMotorStrength(String motorStrength) {
        this.motorStrength = motorStrength;
    }

    public String getEmissionStandard() {
        return emissionStandard;
    }

    public void setEmissionStandard(String emissionStandard) {
        this.emissionStandard = emissionStandard;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getNumCarDoors() {
        return numCarDoors;
    }

    public void setNumCarDoors(String numCarDoors) {
        this.numCarDoors = numCarDoors;
    }

    public String getNumCarSeats() {
        return numCarSeats;
    }

    public void setNumCarSeats(String numCarSeats) {
        this.numCarSeats = numCarSeats;
    }

    public String getFuelEconomy() {
        return fuelEconomy;
    }

    public void setFuelEconomy(String fuelEconomy) {
        this.fuelEconomy = fuelEconomy;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getShortNote() {
        return shortNote;
    }

    public void setShortNote(String shortNote) {
        this.shortNote = shortNote;
    }

    public String getLongNote() {
        return longNote;
    }

    public void setLongNote(String longNote) {
        this.longNote = longNote;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public Map<String, List<String>> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Map<String, List<String>> specifications) {
        this.specifications = specifications;
    }
}
