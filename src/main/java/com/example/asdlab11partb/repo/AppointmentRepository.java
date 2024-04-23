package com.example.asdlab11partb.repo;

import com.example.asdlab11partb.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
