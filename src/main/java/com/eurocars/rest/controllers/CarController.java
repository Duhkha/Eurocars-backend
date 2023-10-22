package com.eurocars.rest.controllers;

import com.eurocars.core.model.Car;
import com.eurocars.core.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService=carService;
    }

    @GetMapping
    public List<Car> findAll(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable int id){
        return carService.findById(id);
    }

}
