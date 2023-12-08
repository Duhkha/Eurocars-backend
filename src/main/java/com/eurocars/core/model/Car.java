package com.eurocars.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.eurocars.core.model.enums.CarStatus;

import java.util.Date;
import java.util.List;

@Document(collection = "cars")
public class Car {

    @Id
    private String id;
    private CarStatus carStatus;
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
    private List<String> equipment;
    private Date creationDate;

    private String  town;

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }




}

