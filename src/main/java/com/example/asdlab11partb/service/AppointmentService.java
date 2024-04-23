package com.example.asdlab11partb.service;

import com.example.asdlab11partb.entity.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment newAppointment(Appointment appointment);

    List<Appointment> findAll();
}
