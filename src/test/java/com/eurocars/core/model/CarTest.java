package com.eurocars.core.model;

import com.eurocars.core.model.enums.CarStatus;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testCarIdGetterSetter() {
        Car car = new Car();
        String id = "12345";
        car.setId(id);
        assertEquals(id, car.getId());
    }

    @Test
    void testCarStatusGetterSetter() {
        Car car = new Car();
        CarStatus status = CarStatus.AVAILABLE;
        car.setCarStatus(status);
        assertEquals(status, car.getCarStatus());
    }

    @Test
    void testCarMakeGetterSetter() {
        Car car = new Car();
        String make = "Toyota";
        car.setMake(make);
        assertEquals(make, car.getMake());
    }

    @Test
    void testCarModelGetterSetter() {
        Car car = new Car();
        String model = "Corolla";
        car.setModel(model);
        assertEquals(model, car.getModel());
    }

    @Test
    void testCarYearGetterSetter() {
        Car car = new Car();
        Integer year = 2020;
        car.setYear(year);
        assertEquals(year, car.getYear());
    }

    @Test
    void testCarMileageGetterSetter() {
        Car car = new Car();
        Integer mileage = 50000;
        car.setMileage(mileage);
        assertEquals(mileage, car.getMileage());
    }

    @Test
    void testCarPriceWithTaxGetterSetter() {
        Car car = new Car();
        Integer priceWithTax = 20000;
        car.setPriceWithTax(priceWithTax);
        assertEquals(priceWithTax, car.getPriceWithTax());
    }

    @Test
    void testCarPriceWithoutTaxGetterSetter() {
        Car car = new Car();
        Integer priceWithoutTax = 18000;
        car.setPriceWithoutTax(priceWithoutTax);
        assertEquals(priceWithoutTax, car.getPriceWithoutTax());
    }

    @Test
    void testCarMotorGetterSetter() {
        Car car = new Car();
        String motor = "1.8L";
        car.setMotor(motor);
        assertEquals(motor, car.getMotor());
    }

    @Test
    void testCarMotorCapacityGetterSetter() {
        Car car = new Car();
        String motorCapacity = "2.0L";
        car.setMotorCapacity(motorCapacity);
        assertEquals(motorCapacity, car.getMotorCapacity());
    }

    @Test
    void testCarFuelGetterSetter() {
        Car car = new Car();
        String fuel = "Diesel";
        car.setFuel(fuel);
        assertEquals(fuel, car.getFuel());
    }

    @Test
    void testCarMotorStrengthGetterSetter() {
        Car car = new Car();
        String motorStrength = "150HP";
        car.setMotorStrength(motorStrength);
        assertEquals(motorStrength, car.getMotorStrength());
    }

    @Test
    void testCarEmissionStandardGetterSetter() {
        Car car = new Car();
        String emissionStandard = "Euro 6";
        car.setEmissionStandard(emissionStandard);
        assertEquals(emissionStandard, car.getEmissionStandard());
    }

    @Test
    void testCarDrivetrainGetterSetter() {
        Car car = new Car();
        String drivetrain = "AWD";
        car.setDrivetrain(drivetrain);
        assertEquals(drivetrain, car.getDrivetrain());
    }

    @Test
    void testCarCountryOfOriginGetterSetter() {
        Car car = new Car();
        String countryOfOrigin = "Japan";
        car.setCountryOfOrigin(countryOfOrigin);
        assertEquals(countryOfOrigin, car.getCountryOfOrigin());
    }

    @Test
    void testCarTransmissionGetterSetter() {
        Car car = new Car();
        String transmission = "Automatic";
        car.setTransmission(transmission);
        assertEquals(transmission, car.getTransmission());
    }

    @Test
    void testCarBodyStyleGetterSetter() {
        Car car = new Car();
        String bodyStyle = "Sedan";
        car.setBodyStyle(bodyStyle);
        assertEquals(bodyStyle, car.getBodyStyle());
    }

    @Test
    void testCarColorGetterSetter() {
        Car car = new Car();
        String carColor = "Red";
        car.setCarColor(carColor);
        assertEquals(carColor, car.getCarColor());
    }

    @Test
    void testCarNumDoorsGetterSetter() {
        Car car = new Car();
        String numDoors = "4";
        car.setNumCarDoors(numDoors);
        assertEquals(numDoors, car.getNumCarDoors());
    }

    @Test
    void testCarNumSeatsGetterSetter() {
        Car car = new Car();
        String numSeats = "5";
        car.setNumCarSeats(numSeats);
        assertEquals(numSeats, car.getNumCarSeats());
    }

    @Test
    void testCarFuelEconomyGetterSetter() {
        Car car = new Car();
        String fuelEconomy = "20 MPG";
        car.setFuelEconomy(fuelEconomy);
        assertEquals(fuelEconomy, car.getFuelEconomy());
    }

    @Test
    void testCarRegistrationGetterSetter() {
        Car car = new Car();
        String registration = "ABC123";
        car.setRegistration(registration);
        assertEquals(registration, car.getRegistration());
    }

    @Test
    void testCarShortNoteGetterSetter() {
        Car car = new Car();
        String shortNote = "Well maintained";
        car.setShortNote(shortNote);
        assertEquals(shortNote, car.getShortNote());
    }

    @Test
    void testCarLongNoteGetterSetter() {
        Car car = new Car();
        String longNote = "This car has a full service history";
        car.setLongNote(longNote);
        assertEquals(longNote, car.getLongNote());
    }

    @Test
    void testCarTownGetterSetter() {
        Car car = new Car();
        String town = "Springfield";
        car.setTown(town);
        assertEquals(town, car.getTown());
    }

    @Test
    void testCarImageUrlsGetterSetter() {
        Car car = new Car();
        List<String> imageUrls = Arrays.asList("url1", "url2");
        car.setImageUrls(imageUrls);
        assertEquals(imageUrls, car.getImageUrls());
    }

    @Test
    void testCarEquipmentGetterSetter() {
        Car car = new Car();
        List<String> equipment = Arrays.asList("Air Conditioning", "Leather Seats");
        car.setEquipment(equipment);
        assertEquals(equipment, car.getEquipment());
    }

    @Test
    void testCarCreationDateGetterSetter() {
        Car car = new Car();
        Date now = new Date();
        car.setCreationDate(now);
        assertEquals(now, car.getCreationDate());
    }




}
