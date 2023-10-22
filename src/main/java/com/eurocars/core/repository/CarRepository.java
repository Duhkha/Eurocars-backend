package com.eurocars.core.repository;

import com.eurocars.core.model.Car;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarRepository {
    private List<Car> cars;

    public CarRepository(){
        this.cars= Arrays.asList(
                new Car("1", "BMW M3", 80000, 2012, 75000.00),
                new Car("2", "Mercedes SLK200", 125000, 2007, 10000.00),
                new Car("3", "Audi S8", 35000, 2023, 85000.00)
        );
    }

    public List<Car> findAll(){
        return cars;
    }

    public Car findById(int id){
        return cars.stream()
                .filter(car -> Integer.toString(id).equals(car.getId()))
                .findFirst()
                .orElse(null);
    }



}
