package com.applicationservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;
    private String name;
    private String type;
    @Lob //Used to convert file into binary format
    private byte[] fileData;
    private int jobSeekerId;
    private int jobId;

}
