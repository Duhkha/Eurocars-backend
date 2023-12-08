package com.eurocars.core.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection="garages")
public class UserGarage {

    @Id
    private String id;
    private String userId;
    private List<String> carIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getCarIds() {
        return carIds;
    }

    public void setCarIds(List<String> carIds) {
        this.carIds = carIds;
    }
}