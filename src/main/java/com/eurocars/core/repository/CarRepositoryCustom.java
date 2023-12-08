package com.eurocars.core.repository;
import com.eurocars.core.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public interface CarRepositoryCustom {
    Page<Car> executeQuery(Query query, Pageable pageable);


    }
