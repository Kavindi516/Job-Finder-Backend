package com.jobSeekerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class JobSeeker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobSeekerId;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String gender;
    private String email;
    private String password;

}
