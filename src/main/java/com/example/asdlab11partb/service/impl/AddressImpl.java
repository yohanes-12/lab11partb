package com.example.asdlab11partb.service.impl;

import com.example.asdlab11partb.dto.AddressWithPatientDTO;
import com.example.asdlab11partb.repo.AddressRepository;
import com.example.asdlab11partb.service.AddressService;
import lombok.AllArgsConstructor;
import com.example.asdlab11partb.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressImpl implements AddressService {



    private AddressRepository addressRepository;
    @Override
    public Address newAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<AddressWithPatientDTO> getAllAddress() {

        List<Address> addresses = addressRepository.getAllAddressesWithPatientSortedByCityASC();
        return addresses.stream().map(AddressWithPatientDTO::fromAddress).toList();

    }


}
