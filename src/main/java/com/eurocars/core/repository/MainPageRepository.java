package com.eurocars.core.repository;

import com.eurocars.core.model.MainPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MainPageRepository extends MongoRepository<MainPage, String> {


}
