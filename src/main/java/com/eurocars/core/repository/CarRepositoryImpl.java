package com.eurocars.core.repository;

import com.eurocars.core.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepositoryImpl implements CarRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public CarRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public Page<Car> executeQuery(Query query, Pageable pageable) {
        // Get the total count before applying pagination
        long totalCount = mongoTemplate.count(query, Car.class);

        // Apply pagination to the query
        query.with(pageable);

        // Use mongoTemplate to execute the query and return a Page
        List<Car> cars = mongoTemplate.find(query, Car.class);

        return new PageImpl<>(cars, pageable, totalCount);
    }
}
