package com.example.asdlab11partb.service.impl;

import com.example.asdlab11partb.entity.Appointment;
import com.example.asdlab11partb.repo.AppointmentRepository;
import com.example.asdlab11partb.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Override
    public Appointment newAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

}
