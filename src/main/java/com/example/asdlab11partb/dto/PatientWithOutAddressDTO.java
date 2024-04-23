package com.example.asdlab11partb.dto;

import com.example.asdlab11partb.entity.Patient;
import lombok.Data;
@Data
public class PatientWithOutAddressDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;




    private String patientNo;

    public static PatientWithOutAddressDTO fromPatient(Patient p) {
        PatientWithOutAddressDTO patient = new PatientWithOutAddressDTO();
        patient.firstName = p.getFirstName();
        patient.lastName = p.getLastName();
        patient.email = p.getEmail();
        patient.phone = p.getPatientNo();

        patient.patientNo = p.getPatientNo();


        return patient;

    }


    public Patient toPatient(){

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setEmail(email);
        patient.setPhone(phone);
        patient.setPatientNo(patientNo);

        return patient;

    }
}
