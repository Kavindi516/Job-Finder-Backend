package com.companyservice.response;

import lombok.Data;

@Data
public class companyResponse {
    private int companyId;
    private String companyName;
    private String location;
    private String industry;
    private String contactDetails;
}
