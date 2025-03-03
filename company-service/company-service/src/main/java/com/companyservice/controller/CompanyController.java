package com.companyservice.controller;

import com.companyservice.model.Company;
import com.companyservice.request.LoginRequest;
import com.companyservice.response.LoginResponse;
import com.companyservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController// This annotation marks the class as a controller in a Spring MVC application.
@RequestMapping(path = "/company-service/api") //Maps the controller's request mapping to /company-service/api.It means all endpoints defined in this controller will be prefixed with /company-service/api
@CrossOrigin
public class CompanyController {
    @Autowired//This annotation is used for automatic dependency injection. It injects an instance of CompanyService into the controller.
    private CompanyService companyService;//This field holds an instance of the CompanyService

    //Creating new Company
    @PostMapping(path = "/company")//It maps HTTP POST requests to /company-service/api/company
    public ResponseEntity<Company> createNewCompany(@RequestBody Company company){ //This method creates a new company by invoking the 'createNewCompany' method of companyService.
        System.out.println("New company created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createNewCompany(company));
    }//It returns a ResponseEntity with the created company object and an HTTP status of 201 CREATED.

    //Get all Companies
    @GetMapping(path = "/companies")//it maps HTTP GET requests to '/company-service/api/companies'.
    public ResponseEntity<List<Company>> allCompanies() throws Exception{ //It gets all companies by invoking the 'allCompanies' method of companyService.
        return ResponseEntity.status(HttpStatus.OK).body(companyService.allCompanies());
        //It returns a list of all companies retrieved from the companyService in a responseEntity with an HTTP status of 200 OK.
    }

    //Login Company
    @PostMapping(path = "/company/login")//it maps HTTP POST requests to '/company-service/api/company/login'.
    public ResponseEntity<LoginResponse> loginCompany(@RequestBody LoginRequest loginRequest) throws Exception{
        //This method invokes the loginCompany method of companyService to perform the login process
        LoginResponse loginResponse = companyService.loginCompany(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);//It returns the company id
    }

    //Get logged company details
    @GetMapping(path = "/company/{companyId}")              //Here {companyId} is a path variable representing the ID of the company to retrieve.
    public ResponseEntity<Optional<Company>> getCompanyById(@PathVariable int companyId){
        //This method retrieves a company details by its ID using the getCompanyById method of companyService
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanyById(companyId));
        //It returns a ResponseEntity containing an Optional with the company object and an HTTP status of 200 OK.
    }
}
