package com.eurocars.core.repository;

import com.eurocars.core.model.UserGarage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGarageRepository extends MongoRepository<UserGarage, String> {


    UserGarage findByUserId(String userId);
    void deleteByUserId(String userId);

    boolean existsByUserIdAndCarIdsContaining(String userId, String carId);



}
