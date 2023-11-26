package com.eurocars.rest.dto;

import com.eurocars.core.model.User;
import com.eurocars.core.model.enums.UserType;
import org.springframework.stereotype.Component;

import java.util.Date;


public class UserRequestDTO {
    private UserType userType;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;


    public  UserRequestDTO() { }

    public UserRequestDTO(User user) {
        this.userType = user.getUserType();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone=user.getPhone();
    }

    public User toEntity() {
        User user = new User();
        user.setUserType(userType);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setCreationDate(new java.util.Date());
        return user;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
