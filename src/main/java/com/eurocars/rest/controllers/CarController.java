package com.eurocars.rest.controllers;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.enums.CarStatus;
import com.eurocars.core.service.CarService;
import com.eurocars.rest.dto.CarDTO;
import com.eurocars.rest.dto.CarRequestDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
public ResponseEntity<List<Car>> getCars() {
    List<Car> cars = carService.getCars();
    return ResponseEntity.ok(cars);
}

--- og one

@RequestMapping(method = RequestMethod.GET, path = "/")
public ResponseEntity<List<CarDTO>> getCars() {

    return ResponseEntity.ok(carService.getCars());
}

    */

    @RequestMapping(method = RequestMethod.GET, path = "")
    public ResponseEntity<Page<CarDTO>> getCars(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> sortBy,
            @RequestParam(required = false) Optional<Sort.Direction> sortOrder,
            @RequestParam(required = false) List<String> make,
            @RequestParam(required = false) List<String> model,
            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxYear,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) List<String> fuel,
            @RequestParam(required = false) List<String> transmission,
            @RequestParam(required = false) List<String> bodyStyle,
            @RequestParam(required = false) Integer minMileage,
            @RequestParam(required = false) Integer maxMileage,
            @RequestParam(required = false) List<CarStatus> carStatus,
            @RequestParam(required = false) List<String> town
    ) {
        // Set default values if not present
        int pageValue = page.orElse(0);
        int sizeValue = size.orElse(2);
        String sortByValue = sortBy.orElse("creationDate");
        Sort.Direction sortOrderValue = sortOrder.orElse(Sort.Direction.DESC);

        // Create a map of filters based on the request parameters
        Map<String, Object> filters = new HashMap<>();
        filters.put("make", make);
        filters.put("model", model);
        filters.put("minYear", minYear);
        filters.put("maxYear", maxYear);
        filters.put("minPrice", minPrice);
        filters.put("maxPrice", maxPrice);
        filters.put("fuel", fuel);
        filters.put("transmission", transmission);
        filters.put("bodyStyle", bodyStyle);
        filters.put("minMileage", minMileage);
        filters.put("maxMileage", maxMileage);
        filters.put("carStatus", carStatus);
        filters.put("town", town);

        // Call the service method with the provided parameters
        Page<CarDTO> resultPage = carService.getCarsWithFilterAndSorting(
                filters, sortByValue, sortOrderValue, pageValue, sizeValue);

        // Return the result as a ResponseEntity
        return ResponseEntity.ok(resultPage);
    }



    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Optional<Car>> findCarById(@PathVariable String id) {
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

    /*

     @GetMapping("/search")
    public ResponseEntity<List<CarDTO>> searchCars(
            @RequestParam(required = false) List<String> make,
            @RequestParam(required = false) List<String> model,
            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxYear,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) List<String> fuel,
            @RequestParam(required = false) List<String> transmission,
            @RequestParam(required = false) List<String> bodyStyle,
            @RequestParam(required = false) Integer minMileage,
            @RequestParam(required = false) Integer maxMileage,
            @RequestParam(required = false) List<CarStatus> carStatus,
            @RequestParam(required = false) List<String> town
    ) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("make", make);
        filters.put("model", model);
        filters.put("minYear", minYear);
        filters.put("maxYear", maxYear);
        filters.put("minPrice", minPrice);
        filters.put("maxPrice", maxPrice);
        filters.put("fuel", fuel);
        filters.put("transmission", transmission);
        filters.put("bodyStyle", bodyStyle);
        filters.put("minMileage", minMileage);
        filters.put("maxMileage", maxMileage);
        filters.put("carStatus", carStatus);
        filters.put("town",town);


        List<CarDTO> filteredCars = carService.searchCars(filters);
        return ResponseEntity.ok(filteredCars);
    }


     */









}