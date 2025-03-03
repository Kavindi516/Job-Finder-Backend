package com.companyservice.service;

import com.companyservice.model.Company;
import com.companyservice.repository.CompanyRepository;
import com.companyservice.response.LoginResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // This shows the class as a Spring service component,
public class CompanyService {
    @Autowired // This annotation is used for automatic dependency injection. It injects instances of CompanyRepository and ModelMapper into the service.
    private CompanyRepository companyRepository; // This field holds an instance of the CompanyRepository, which is used to interact with the database for company-related operations.
    @Autowired
    private ModelMapper modelMapper;

    public Company createNewCompany(Company company){ //This method is responsible for creating a new company. It takes a Company object as a parameter,
        return companyRepository.save(company); // then saves it to the database using the companyRepository, and returns the saved Company object.
    }
    public List<Company> allCompanies() throws Exception{
        return companyRepository.findAll();
    }// This method retrieves all companies from the database using the findAll() method provided by companyRepository and returns a list of Company objects.

    public LoginResponse loginCompany(String email, String password) { //This method handles the login process for a company.
        Object result = companyRepository.findByCredentials(email, password); //It invokes the custom query method findByCredentials of companyRepository to find a company by email and password.
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCompanyId((Integer) result); //Then it constructs a LoginResponse object with the retrieved company ID and returns it.
        return loginResponse;
    }
    //
    public Optional<Company> getCompanyById(int companyId) { //This method retrieves a company by its ID.
        return companyRepository.findById(companyId); // It invokes the findById method of companyRepository and returns an Optional containing the found Company object
    }
}