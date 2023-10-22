package com.eurocars.core.service;

import com.eurocars.core.model.Car;
import com.eurocars.core.repository.CarRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository){

        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(@PathVariable int id){
        return carRepository.findById(id);
    }

}

