package com.example.asdlab11partb.controller;

import com.example.asdlab11partb.dto.AddressWithPatientDTO;
import com.example.asdlab11partb.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/list")
    public List<AddressWithPatientDTO> getAddresses(){
        return addressService.getAllAddress();
    }
}
