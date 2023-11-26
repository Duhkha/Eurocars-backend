package com.eurocars.core.service;

import com.eurocars.core.model.Car;
import com.eurocars.core.repository.CarRepository;

import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.CarDTO;
import com.eurocars.rest.dto.CarRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

  /*  public List<CarDTO> getCars() {
        List<Car> cars=carRepository.findAll();
        return cars
                .stream()
                .map(CarDTO::new)
                .collect(toList());
    }
*/

    public List<Car> getCars() {
        return carRepository.getAllCars();
    }

    public CarDTO findCarById(String id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()) {
            throw new ResourceNotFoundException("The car with the given ID does not exist.");
        }
        return new CarDTO(car.get());
    }

    public CarDTO addCar(CarRequestDTO payload) {
        Car car=carRepository.save(payload.toEntity());
        return new CarDTO(car);
    }

    public CarDTO updateCar(String id, CarRequestDTO payload) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()) {
            throw new ResourceNotFoundException("The car with the given ID does not exist.");
        }
        Car updatedCar= payload.toEntity();
        updatedCar.setId(car.get().getId());
        updatedCar=carRepository.save(updatedCar);


        return new CarDTO(updatedCar);
    }

    public void deleteCar(String id) {
        Optional<Car> car = carRepository.findById(id);
        car.ifPresent(carRepository::delete);
    }
}