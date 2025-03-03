package com.jobSeekerservice.controller;

import com.jobSeekerservice.model.JobSeeker;
import com.jobSeekerservice.request.LoginRequest;
import com.jobSeekerservice.response.LoginResponse;
import com.jobSeekerservice.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/job-seeker-service/api")
public class JobSeekerController {
    @Autowired
    private JobSeekerService jobSeekerService;

    //Register Job Seeker to the system

    @PostMapping(path = "/job-seeker")
    public ResponseEntity<JobSeeker> createNewJobSeeker(@RequestBody JobSeeker jobSeeker){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobSeekerService.createNewJobSeeker(jobSeeker));
    }

    //Login Job Seeker to the system
    @PostMapping(path = "/job-seeker/login")
    public ResponseEntity<LoginResponse> loginJobSeeker(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = jobSeekerService.loginJobSeeker(loginRequest.getEmail(), loginRequest.getPassword());
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }
}
