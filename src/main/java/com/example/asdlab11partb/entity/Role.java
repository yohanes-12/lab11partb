package com.example.asdlab11partb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue()
    private Long id;

    private RoleType roleType;


    public enum RoleType {
        OfficeManager, DENTIST, PATIENT
    }




}


