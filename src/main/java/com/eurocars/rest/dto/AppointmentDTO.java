package com.eurocars.rest.dto;

import com.eurocars.core.model.Appointment;

import java.util.Date;

public class AppointmentDTO {
    private String id;
    private String userId; // Assuming this is the ID of the user (either logged in or not) interested in the appointment
    private String carId; // Assuming this is the ID of the car the user is interested in

    private String userName;

    private String userEmail;
    private String note;
    private Date appointmentDate;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.userId = appointment.getUserId();
        this.userName= appointment.getUserName();
        this.userEmail= appointment.getUserEmail();
        this.carId = appointment.getCarId();
        this.note = appointment.getNote();
        this.appointmentDate = appointment.getAppointmentDate();
    }

    // Getters and setters

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
}
