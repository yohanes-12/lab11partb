package com.example.asdlab11partb.impl;


import com.example.asdlab11partb.dto.AddressWithOutPatientDTO;
import com.example.asdlab11partb.dto.PatientWithAddressDTO;
import com.example.asdlab11partb.exceptions.NotFoundException;
import com.example.asdlab11partb.service.impl.PatientServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@RunWith(SpringRunner.class)
class PatientServiceImplTest {

    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:latest");

    @Autowired
    private PatientServiceImpl patientService;


    @BeforeAll
    static void beforeAll() {
        mysql.start();
    }

    @AfterAll
    static void afterAll() {
        mysql.stop();
    }

    @DynamicPropertySource
    static void setDataSourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create");
    }






    @Test
    @DisplayName("Test Fetch Patient By ID for existing patient")
    void getPatientById() {
        PatientWithAddressDTO patientWithAddressDTO = new PatientWithAddressDTO();
        patientWithAddressDTO.setFirstName("John");
        patientWithAddressDTO.setLastName("Doe");
        patientWithAddressDTO.setEmail("email@ema.ccd");
        patientWithAddressDTO.setPhone("1234567890");
        AddressWithOutPatientDTO address = new AddressWithOutPatientDTO();
        address.setCity("City");
        address.setAddressOne("Address");
        address.setState("State");
        patientWithAddressDTO.setMailingAddress(address);
          PatientWithAddressDTO p =  patientService.registerPatient(patientWithAddressDTO);

        PatientWithAddressDTO actual =    patientService.getPatientById(p.getId());
        assertEquals(p.getId(), actual.getId());


    }
    @Test
    @DisplayName("Test Fetch Patient By ID for non existing patient, should throw an exception")
    void getPatientById2() {
        assertThrows(NotFoundException.class, () -> {
            PatientWithAddressDTO actual =    patientService.getPatientById(1000L);
        });





    }
}