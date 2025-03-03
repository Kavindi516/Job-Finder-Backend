package com.jobservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity //This shows the company class is a JPA. which means it will be mapped to a database table.
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    private String title;
    private String description;
    private String category;
    private String requirements;
    private String workTime;
    private String companyName;
    private LocalDate deadline;
    private String location;
    private int companyId;
}
