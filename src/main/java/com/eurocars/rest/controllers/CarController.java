package com.eurocars.rest.controllers;

import com.eurocars.core.model.Car;
import com.eurocars.core.service.CarService;
import com.eurocars.rest.dto.CarDTO;
import com.eurocars.rest.dto.CarRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@SecurityRequirement(name = "JWT Security")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }
/*
    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<CarDTO>> getCars() {

        return ResponseEntity.ok(carService.getCars());
    }*/
@RequestMapping(method = RequestMethod.GET, path = "/")
public ResponseEntity<List<Car>> getCars() {
    List<Car> cars = carService.getCars();
    return ResponseEntity.ok(cars);
}

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CarDTO> findCarById(@PathVariable String id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    /*
    filter cars
     */

    @RequestMapping(method = RequestMethod.POST,path = "/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CarDTO> addCar(@RequestBody CarRequestDTO car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String id, @RequestBody CarRequestDTO car) {
        return ResponseEntity.ok(carService.updateCar(id,car));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteCar(@PathVariable String id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}