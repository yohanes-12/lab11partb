package com.example.asdlab11partb.controller;

import com.example.asdlab11partb.dto.PatientWithAddressDTO;
import com.example.asdlab11partb.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.iterableWithSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;


    @Test
    public void testListPatients() throws Exception {

        PatientWithAddressDTO patient1 = new PatientWithAddressDTO();
//
        patient1.setId(1L);
        patient1.setFirstName("John");
        patient1.setLastName("Doe");
        patient1.setEmail("email@asdas.com");
        patient1.setPhone("123456789");
        patient1.setPatientNo("123456789");

        PatientWithAddressDTO patient2 = new PatientWithAddressDTO();
        patient2.setId(2L);
        patient2.setFirstName("Jane");
        patient2.setLastName("Doe");
        patient2.setEmail("jane@mail.clom");
        patient2.setPhone("987654321");
        patient2.setPatientNo("987654321");






        List<PatientWithAddressDTO> patients = Arrays.asList(
                patient1,
                patient2
        );
        when(patientService.getAllPatients()).thenReturn(patients);
        mockMvc.perform(get("/adsweb/api/v1/patient/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", iterableWithSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].firstName").value("John"))
                .andExpect(jsonPath("$[0].lastName").value("Doe"))
                .andExpect(jsonPath("$[0].email").value("email@asdas.com"))
                .andExpect(jsonPath("$[0].phone").value("123456789"))
                .andExpect(jsonPath("$[0].patientNo").value("123456789"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].firstName").value("Jane"))
                .andExpect(jsonPath("$[1].lastName").value("Doe"))
                .andExpect(jsonPath("$[1].email").value("jane@mail.clom"))
                .andExpect(jsonPath("$[1].phone").value("987654321"))
                .andExpect(jsonPath("$[1].patientNo").value("987654321"));


    }

}