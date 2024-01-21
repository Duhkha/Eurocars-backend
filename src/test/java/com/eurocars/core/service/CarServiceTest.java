package com.eurocars.core.service;

import com.eurocars.core.model.Car;
import com.eurocars.core.repository.CarRepository;
import com.eurocars.core.repository.CarRepositoryImpl;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.CarDTO;
import com.eurocars.rest.dto.CarRequestDTO;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CarServiceTest {

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private CarRepositoryImpl carRepositoryImpl;

    @Autowired
    private CarService carService;

    @Test
    public void shouldAddCar() {
        CarRequestDTO carRequestDTO = new CarRequestDTO(); // Populate with test data as needed
        Car car = carRequestDTO.toEntity();
        Mockito.when(carRepository.save(ArgumentMatchers.any(Car.class))).thenReturn(car);

        CarDTO savedCar = carService.addCar(carRequestDTO);

        assertThat(savedCar).isNotNull();
    }

    @Test
    public void shouldUpdateCar() {
        String carId = "xyxyxyxy";
        CarRequestDTO carRequestDTO = new CarRequestDTO(); // Populate with test data as needed
        Car car = carRequestDTO.toEntity();

        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.of(car));
        Mockito.when(carRepository.save(ArgumentMatchers.any(Car.class))).thenReturn(car);

        CarDTO updatedCar = carService.updateCar(carId, carRequestDTO);

        assertThat(updatedCar).isNotNull();
        // Additional assertions as necessary
    }

    @Test
    public void shouldThrowExceptionWhenUpdateCarNotFound() {
        String carId = "xyxy";
        CarRequestDTO carRequestDTO = new CarRequestDTO();

        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            carService.updateCar(carId, carRequestDTO);
        });
    }

    @Test
    public void shouldDeleteCar() {
        String carId = "12233";
        Car car = new Car();
        car.setId(carId);

        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.of(car));
        doNothing().when(carRepository).delete(car);

        carService.deleteCar(carId);

        verify(carRepository, times(1)).delete(car);
    }

    @Test
    public void shouldNotDeleteNonExistingCar() {
        String carId = "asad1212";

        Mockito.when(carRepository.findById(carId)).thenReturn(Optional.empty());

        carService.deleteCar(carId);

        verify(carRepository, never()).delete(any(Car.class));
    }

    @Test
    public void testAddCar() {
        CarRequestDTO carRequestDTO = new CarRequestDTO();
        carRequestDTO.setMake("Toyota");
        carRequestDTO.setModel("Corolla");
        carRequestDTO.setYear(2020);
        carRequestDTO.setPriceWithTax(20000);

        // Convert CarRequestDTO to Car entity
        Car car = carRequestDTO.toEntity();

        // Mock the behavior of the save method
        Mockito.when(carRepository.save(ArgumentMatchers.any(Car.class))).thenReturn(car);

        // Call the addCar method in the CarService
        CarDTO savedCar = carService.addCar(carRequestDTO);

        // Assertions to verify the Car is added correctly
        assertThat(savedCar.getMake()).isEqualTo(car.getMake());
        assertThat(savedCar.getModel()).isEqualTo(car.getModel());
    }

}
