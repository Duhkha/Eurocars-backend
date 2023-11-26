package com.eurocars.core.service;

import com.eurocars.core.model.Appointment;
import com.eurocars.core.repository.AppointmentRepository;
import com.eurocars.exceptions.repository.ResourceNotFoundException;
import com.eurocars.rest.dto.AppointmentDTO;
import com.eurocars.rest.dto.AppointmentRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointments() {
        return appointmentRepository.getAllAppointments();
    }

    public AppointmentDTO findAppointmentById(String id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty()) {
            throw new ResourceNotFoundException("The appointment with the given ID does not exist.");
        }
        return new AppointmentDTO(appointment.get());
    }

    public AppointmentDTO addAppointment(AppointmentRequestDTO payload) {
        Appointment appointment = appointmentRepository.save(payload.toEntity());
        return new AppointmentDTO(appointment);
    }

    public AppointmentDTO updateAppointment(String id, AppointmentRequestDTO payload) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isEmpty()) {
            throw new ResourceNotFoundException("The appointment with the given ID does not exist.");
        }
        Appointment updatedAppointment = payload.toEntity();
        updatedAppointment.setId(appointment.get().getId());
        updatedAppointment = appointmentRepository.save(updatedAppointment);

        return new AppointmentDTO(updatedAppointment);
    }

    public void deleteAppointment(String id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        appointment.ifPresent(appointmentRepository::delete);
    }
}