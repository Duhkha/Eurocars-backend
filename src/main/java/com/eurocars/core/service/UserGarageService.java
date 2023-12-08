package com.eurocars.core.service;

import com.eurocars.core.model.UserGarage;
import com.eurocars.core.repository.UserGarageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserGarageService {
    private final UserGarageRepository userGarageRepository;

    public UserGarageService (UserGarageRepository userGarageRepository){
        this.userGarageRepository=userGarageRepository;
    }
    public void createUserGarage(String id) {
        UserGarage userGarage = new UserGarage();
        userGarage.setUserId(id);
        userGarageRepository.save(userGarage);

    }
    public UserGarage getUserGarage(String userId) {
        return userGarageRepository.findByUserId(userId);
    }


    public void addCarToGarage(String userId, String carId) {
        UserGarage userGarage = userGarageRepository.findByUserId(userId);
        if (userGarage != null) {
            List<String> carIds = userGarage.getCarIds();

            if (carIds == null) {
                carIds = new ArrayList<>();
            }

            carIds.add(carId);
            userGarage.setCarIds(carIds);
            userGarageRepository.save(userGarage);
        }
    }

    public void removeCarFromGarage(String userId, String carId) {
        UserGarage userGarage = userGarageRepository.findByUserId(userId);
        if (userGarage != null) {
            List<String> carIds = userGarage.getCarIds();
            if (carIds != null) {
                carIds.remove(carId);
                userGarage.setCarIds(carIds);
                userGarageRepository.save(userGarage);
            }
        }
    }
}
