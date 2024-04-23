package com.example.asdlab11partb.dto;

import lombok.Data;

import com.example.asdlab11partb.entity.Patient;
import java.time.LocalDate;

@Data
public class PatientWithAddressDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;



    private AddressWithOutPatientDTO mailingAddress;
    private LocalDate dateOfBirth;

    private String patientNo;

    public static PatientWithAddressDTO fromPatient(Patient p) {
        PatientWithAddressDTO patient = new PatientWithAddressDTO();
        patient.id = p.getId();
        patient.firstName = p.getFirstName();
        patient.lastName = p.getLastName();
        patient.email = p.getEmail();
        patient.phone = p.getPatientNo();

        patient.mailingAddress = AddressWithOutPatientDTO.fromAddress(p.getMailingAddress());
        patient.dateOfBirth = p.getDateOfBirth();
        patient.patientNo = p.getPatientNo();


        return patient;

    }


    public Patient toPatient(){

        Patient patient = new Patient();

        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setEmail(email);
        patient.setPhone(phone);
        if(mailingAddress != null) {

            patient.setMailingAddress(mailingAddress.toAddress(getMailingAddress()));
        }
        patient.setDateOfBirth(dateOfBirth);
        patient.setPatientNo(patientNo);

        return patient;

    }

}
