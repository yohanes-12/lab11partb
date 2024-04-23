package com.example.asdlab11partb.repo;

import com.example.asdlab11partb.entity.Patient;
import com.example.asdlab11partb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("SELECT DISTINCT p FROM Patient p LEFT JOIN Address a ON p.mailingAddress.id = a.id ORDER BY p.lastName ASC")
    List<Patient> getAllPatientsSortedByLastNameASC();

    @Query("SELECT DISTINCT p FROM Patient p WHERE p.id = :id")
    Optional<Patient> findPatientById(@Param("id") Long id);

    @Query("SELECT DISTINCT p FROM Patient p WHERE p.firstName LIKE %:search% OR p.lastName LIKE %:search% OR p.patientNo LIKE %:search% OR  p.email LIKE %:search% OR p.phone LIKE %:search% OR   p.mailingAddress.city LIKE %:search% OR p.mailingAddress.state LIKE %:search% OR p.mailingAddress.addressOne LIKE %:search%")
    List<Patient> searchPatientByAllFields(@Param("search") String search);
}
