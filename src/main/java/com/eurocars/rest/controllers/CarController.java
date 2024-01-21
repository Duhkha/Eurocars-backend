package com.eurocars.rest.controllers;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.enums.CarStatus;
import com.eurocars.core.service.CarService;
import com.eurocars.exceptions.GeneralException;
import com.eurocars.rest.dto.CarDTO;
import com.eurocars.rest.dto.CarRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@RestController
@RequestMapping("api/cars")
@SecurityRequirement(name = "JWT Security")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Value("${myapp.storage.location}")
    private String storageLocation;


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



 @PostMapping("/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CarDTO> addCar(@RequestPart("car") String carJson,
                                         @RequestPart("images") List<MultipartFile> images) {
     System.out.println("Received car data: "+ carJson);
        CarRequestDTO carRequestDTO;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            carRequestDTO = objectMapper.readValue(carJson, CarRequestDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("Error processing car JSON data", e);
        }

        List<String> imageRelativePaths = processAndStoreImages(images);
        carRequestDTO.setImageUrls(imageRelativePaths);

        CarDTO savedCar = carService.addCar(carRequestDTO);

        return ResponseEntity.ok(savedCar);
    }


    private List<String> processAndStoreImages(List<MultipartFile> images) {
        List<String> imageRelativePaths = new ArrayList<>();

        for (MultipartFile file : images) {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            Path storagePath = Paths.get(storageLocation, filename);

            try {
                Files.copy(file.getInputStream(), storagePath, StandardCopyOption.REPLACE_EXISTING);
                imageRelativePaths.add(filename);  // Store just the filename
            } catch (IOException e) {
                throw new GeneralException("Failed to store file " + filename, e);
            }
        }

        return imageRelativePaths;
    }






/*
og add car no pics
@RequestMapping(method = RequestMethod.POST,path = "/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<CarDTO> addCar(@RequestBody CarRequestDTO car) {
        return ResponseEntity.ok(carService.addCar(car));
}
 */



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