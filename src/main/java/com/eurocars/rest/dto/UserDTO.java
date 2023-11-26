package com.eurocars.rest.dto;

import com.eurocars.core.model.User;
import com.eurocars.core.model.enums.UserType;
import java.util.Date;

public class UserDTO {

    private String id;
    private String name;
    private UserType userType;
    private String email;
    private Date creationDate;


    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getFirstName() + " " +user.getLastName();
        this.userType = user.getUserType();
        this.email = user.getEmail();
        this.creationDate = user.getCreationDate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }




    public void setName(String name) {
        this.name = name;
    }



    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
