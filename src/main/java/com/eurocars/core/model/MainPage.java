package com.eurocars.core.model;

import com.eurocars.rest.dto.CarDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "mainPage")
public class MainPage {

    @Id
    private String id;

    private List<String> slideshowImages;

    @DBRef
    private List<CarDTO> upcomingCars;

    @DBRef
    private List<CarDTO> newArrivals;

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSlideshowImages() {
        return slideshowImages;
    }

    public void setSlideshowImages(List<String> slideshowImages) {
        this.slideshowImages = slideshowImages;
    }

    public List<CarDTO> getUpcomingCars() {
        return upcomingCars;
    }

    public void setUpcomingCars(List<CarDTO> upcomingCars) {
        this.upcomingCars = upcomingCars;
    }

    public List<CarDTO> getNewArrivals() {
        return newArrivals;
    }

    public void setNewArrivals(List<CarDTO> newArrivals) {
        this.newArrivals = newArrivals;
    }
}
