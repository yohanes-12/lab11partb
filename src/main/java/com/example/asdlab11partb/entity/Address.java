package com.example.asdlab11partb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue()
    private Long id;
    private String addressOne;
    private String city;
    private String state;
    @OneToOne(mappedBy = "mailingAddress")
    private Patient patient;
}
