package com.eurocars.core.service;

import com.eurocars.core.model.Car;
import com.eurocars.core.model.MainPage;
import com.eurocars.core.repository.MainPageRepository;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainPageService {

    private final MainPageRepository mainPageRepository;
    private final CarService carService;

    @Autowired
    public MainPageService(MainPageRepository mainPageRepository, CarService carService) {
        this.mainPageRepository = mainPageRepository;
        this.carService = carService;
    }

    public MainPage createMainPage(List<String> imageUrls, String note) {
        MainPage mainPage = new MainPage();
        mainPage.setId("1");
        mainPage.setSlideshowImages(imageUrls);
        mainPage.setNote(note);

        return mainPageRepository.save(mainPage);
    }

    public MainPage getMainPage() {
        MainPage mainPage = mainPageRepository.findById("1").orElse(new MainPage());

        List<CarDTO> upcomingCars = carService.getUpcomingCars();
        List<CarDTO> newArrivals = carService.getNewArrivals();

        mainPage.setUpcomingCars(upcomingCars);
        mainPage.setNewArrivals(newArrivals);

        return mainPage;
    }

    public MainPage updateMainPage(MainPage updatedMainPage) {

        // Ensure that the ID is 1
        if (!"1".equals(updatedMainPage.getId())) {
            throw new IllegalArgumentException("MainPage with ID 1 can only be updated.");
        }

        MainPage existingMainPage = mainPageRepository.findById("1").orElseThrow(() -> new ResourceNotFoundException("MainPage not found"));

        existingMainPage.setNote(updatedMainPage.getNote());
        existingMainPage.setSlideshowImages(updatedMainPage.getSlideshowImages());

        return mainPageRepository.save(existingMainPage);
    }
}
