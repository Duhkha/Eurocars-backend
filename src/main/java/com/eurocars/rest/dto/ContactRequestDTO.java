package com.eurocars.rest.dto;

import com.eurocars.core.model.Contact;

import java.util.Date;

public class ContactRequestDTO {


    private String firstName;

    private String lastName;

    private String email;


    private String carId;


    private String note;


    private Date creationDate;
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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


    public Contact toEntity() {
        Contact contact = new Contact();
        contact.setCarId(this.carId);
        contact.setNote(this.note);
        contact.setFirstName(this.firstName);
        contact.setLastName(this.lastName);
        contact.setUserEmail(this.email);
        contact.setCreationDate(new java.util.Date());
        contact.setSubject(this.subject);
        return contact;
    }





}
