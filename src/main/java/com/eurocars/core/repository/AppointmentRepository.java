package com.eurocars.core.repository;

import com.eurocars.core.model.Appointment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    @Query("{}")
    List<Appointment> getAllAppointments();
}
