package com.jobSeekerservice.service;

import com.jobSeekerservice.model.JobSeeker;
import com.jobSeekerservice.repository.JobSeekerRepository;
import com.jobSeekerservice.response.LoginResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;
    @Autowired
    private ModelMapper modelMapper;

    public JobSeeker createNewJobSeeker(JobSeeker jobSeeker){
        return jobSeekerRepository.save(jobSeeker);
    }

    public LoginResponse loginJobSeeker(String email, String password) {
        Object result = jobSeekerRepository.findByCredentials(email, password);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setJobSeekerId((Integer) result);
        return loginResponse;
    }
}