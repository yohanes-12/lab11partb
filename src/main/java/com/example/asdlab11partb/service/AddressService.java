package com.example.asdlab11partb.service;

import com.example.asdlab11partb.dto.AddressWithPatientDTO;
import com.example.asdlab11partb.entity.Address;

import java.util.List;

public interface AddressService {
    Address newAddress(Address address);

    List<AddressWithPatientDTO> getAllAddress();
}
