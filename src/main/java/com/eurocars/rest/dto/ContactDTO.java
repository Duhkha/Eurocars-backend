package com.eurocars.rest.dto;

import com.eurocars.core.model.Contact;

import java.util.Date;

public class ContactDTO {


    private String firstName;

    private String lastName;

    private String carId;
    private String userEmail;
    private String note;
    private Date creationDate;

    public ContactDTO() {
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

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public ContactDTO(Contact contact) {
        this.firstName=contact.getFirstName();
        this.lastName=contact.getLastName();
        this.userEmail= contact.getUserEmail();
        this.carId = contact.getCarId();
        this.note = contact.getNote();
        this.creationDate = contact.getCreationDate();
    }

}
