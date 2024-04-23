package com.example.asdlab11partb.dto;

import com.example.asdlab11partb.entity.Address;
import com.example.asdlab11partb.entity.Patient;
import lombok.Data;

@Data
public class AddressWithPatientDTO {

    private Long id;
    private String addressOne;
    private String city;
    private String state;

    private PatientWithOutAddressDTO patient;

    public static AddressWithPatientDTO fromAddress(Address address){
        AddressWithPatientDTO addressWithPatientDTO = new AddressWithPatientDTO();
        addressWithPatientDTO.id = address.getId();
        addressWithPatientDTO.addressOne = address.getAddressOne();
        addressWithPatientDTO.city = address.getCity();
        addressWithPatientDTO.state = address.getState();
        if(address.getPatient() != null) {
            System.out.println("User is not null");
            addressWithPatientDTO.patient = PatientWithOutAddressDTO.fromPatient((Patient) address.getPatient());
        }
        return addressWithPatientDTO;
    }
}
