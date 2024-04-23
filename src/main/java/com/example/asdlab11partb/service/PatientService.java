package com.example.asdlab11partb.service;

import com.example.asdlab11partb.dto.PatientWithAddressDTO;
import com.example.asdlab11partb.dto.PatientWithOutAddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    List<PatientWithAddressDTO> getAllPatients();

    PatientWithAddressDTO getPatientById(Long id);

    PatientWithAddressDTO registerPatient(PatientWithAddressDTO patientDTO);

    PatientWithAddressDTO updatePatient(PatientWithOutAddressDTO patientDTO, Long id);
    void deletePatient(Long id);

    List<PatientWithAddressDTO> searchPatient(String search);


}
