package com.eurocars.core.service;

import com.eurocars.core.model.Car;
import com.eurocars.core.repository.CarRepository;

import com.eurocars.core.repository.CarRepositoryImpl;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.CarDTO;
import com.eurocars.rest.dto.CarRequestDTO;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarRepositoryImpl carRepositoryImpl;

    public CarService(CarRepository carRepository, CarRepositoryImpl carRepositoryImpl) {
        this.carRepository = carRepository;
        this.carRepositoryImpl = carRepositoryImpl;
    }

    /*

      public List<Car> getCars() {
          return carRepository.getAllCars();
      }


  */
    public List<CarDTO> getCars() {
        List<Car> cars=carRepository.getAllCars();
        return cars
                .stream()
                .map(CarDTO::new)
                .collect(toList());
    }


    public List<CarDTO> getUpcomingCars(){
        List<Car> cars=carRepository.getAllUpcoming();
        return cars
                .stream()
                .map(CarDTO::new)
                .collect(toList());
    }

    public List<CarDTO> getNewArrivals(){
        List<Car> cars=carRepository.getAllNew();
        return cars
                .stream()
                .map(CarDTO::new)
                .collect(toList());
    }

    public Optional<Car> findCarById(String id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isEmpty()) {
            throw new ResourceNotFoundException("The car with the given ID does not exist.");
        }
        return car;
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

    public Page<CarDTO> getCarsWithFilterAndSorting(Map<String, Object> filters, String sortBy, Sort.Direction sortOrder, int page, int size) {
        Query query = buildQuery(filters);

        //sorting
        Sort sort = Sort.by(sortOrder, sortBy);
        query.with(sort);

        //pagination
        Pageable pageable = PageRequest.of(page, size,sort);
        Page<Car> resultPage = carRepositoryImpl.executeQuery(query, pageable);

        List<CarDTO> carDTOs = resultPage.getContent().stream()
                .map(CarDTO::new)
                .collect(Collectors.toList());

        return new PageImpl<>(carDTOs, pageable, resultPage.getTotalElements());

    }




    /* old search, 2.0 filter
    public List<CarDTO> searchCars(Map<String, Object> filters) {
        Query query = buildQuery(filters);

        List<Car> filteredCars = carRepositoryImpl.executeQuery(query);

        return filteredCars.stream()
                .map(CarDTO::new)
                .collect(Collectors.toList());
    }
     */

    private Query buildQuery(Map<String, Object> filters) {
        Criteria criteria = new Criteria();

        handleRangeFilter(filters, criteria, "priceWithTax", "minPrice", "maxPrice");
        handleRangeFilter(filters, criteria, "mileage", "minMileage", "maxMileage");
        handleRangeFilter(filters, criteria, "year","minYear","maxYear");

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            //check if value is not null before adding to query
            if (value != null) {
                if (value instanceof List) {
                    // handle makes, models, fuels
                    criteria.and(key).in((List<?>) value);
                } else if (!key.startsWith("min") && !key.startsWith("max")) {
                    // for other attributes
                    criteria.and(key).is(value);
                }
            }
        }

        return new Query(criteria);
    }

    private void handleRangeFilter(Map<String, Object> filters, Criteria criteria, String field, String minKey, String maxKey) {
        Object min = filters.get(minKey);
        Object max = filters.get(maxKey);

        if (min != null && max != null) {
            criteria.and(field).gte(min).lte(max);
        } else if (min != null) {
            criteria.and(field).gte(min);
        } else if (max != null) {
            criteria.and(field).lte(max);
        }
    }












}