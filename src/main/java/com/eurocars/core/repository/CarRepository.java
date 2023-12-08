package com.eurocars.core.repository;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.enums.CarStatus;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListPagingAndSortingRepository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car, String>, CarRepositoryCustom {

    @Query(value = "{name: ?0}")
    List<Car> findByNameCustom(String name);

    @Query(value = "{mileage: { $gte: ?0 }}")
    List<Car> findByMileageGreaterThanOrEqualTo(int mileage);

    @Query(value = "{year: ?0}")
    List<Car> findByYear(int year);

    @Query(value = "{price: { $lte: ?0 }}")
    List<Car> findByPriceLessThanOrEqualTo(double price);

    @Query("{}")
    List<Car> getAllCars();

    Optional<Car> findById(String id);

    @Aggregation(pipeline = {
            "{ $match: { carStatus: 'COMING' } }",
            "{ $sort: { creationDate: -1 } }",
            "{ $limit: 5 }"
    })
    List<Car> getAllUpcoming();

    @Aggregation(pipeline = {
            "{ $match: { carStatus: 'AVAILABLE' } }",
            "{ $sort: { creationDate: -1 } }",
            "{ $limit: 5 }"
    })
    List<Car> getAllNew();



}

