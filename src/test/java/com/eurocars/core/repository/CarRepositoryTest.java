package com.eurocars.core.repository;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.enums.CarStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void shouldFindCarById() {
        String testId = "6563739f98526b029cb675f7";
        Optional<Car> car = carRepository.findById(testId);
        assertTrue(car.isPresent());
        assertEquals(testId, car.get().getId());
    }

    @Test
    public void shouldFindAllCars() {
        List<Car> cars = carRepository.findAll();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
    }

    @Test
    public void shouldFindCarsByYear() {
        int year = 2022;
        List<Car> cars = carRepository.findByYear(year);
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
        cars.forEach(car -> assertEquals(year, car.getYear()));
    }

    @Test
    public void shouldFindCarsByNameCustom() {
        String testName = "BMW";
        List<Car> cars = carRepository.findByNameCustom(testName);
        assertNotNull(cars);
        cars.forEach(car -> assertEquals(testName, car.getMake())); // Assuming 'name' refers to 'make' of the car
    }

    @Test
    public void shouldFindCarsByMileageGreaterThanOrEqualTo() {
        int testMileage = 10000;
        List<Car> cars = carRepository.findByMileageGreaterThanOrEqualTo(testMileage);
        assertNotNull(cars);
        cars.forEach(car -> assertTrue(car.getMileage() >= testMileage));
    }

    @Test
    public void shouldFindCarsByPriceLessThanOrEqualTo() {
        double testPrice = 30000.0;
        List<Car> cars = carRepository.findByPriceLessThanOrEqualTo(testPrice);
        assertNotNull(cars);
        cars.forEach(car -> assertTrue(car.getPriceWithTax() <= testPrice)); // Assuming this refers to 'priceWithTax'
    }

    @Test
    public void shouldGetAllCars() {
        List<Car> cars = carRepository.getAllCars();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
    }

    @Test
    public void shouldGetAllUpcomingCars() {
        List<Car> cars = carRepository.getAllUpcoming();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
        cars.forEach(car -> assertEquals(CarStatus.COMING, car.getCarStatus()));
    }

    @Test
    public void shouldGetAllNewCars() {
        List<Car> cars = carRepository.getAllNew();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
        cars.forEach(car -> assertEquals(CarStatus.AVAILABLE, car.getCarStatus()));
    }


}
