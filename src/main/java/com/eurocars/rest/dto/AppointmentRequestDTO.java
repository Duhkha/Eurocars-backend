package com.eurocars.rest.dto;

import com.eurocars.core.model.Appointment;

import java.util.Date;

public class AppointmentRequestDTO {

    private String userId;
    private String userName;

    private String userEmail;


    private String carId;


    private String note;


    private Date appointmentDate;



    // Getters and setters

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // Conversion method to convert to Appointment entity
    public Appointment toEntity() {
        Appointment appointment = new Appointment();
        appointment.setUserId(this.userId);
        appointment.setCarId(this.carId);
        appointment.setNote(this.note);
        appointment.setUserName(this.userName);
        appointment.setUserEmail(this.userEmail);
        appointment.setAppointmentDate(this.appointmentDate);
        return appointment;
    }
}
