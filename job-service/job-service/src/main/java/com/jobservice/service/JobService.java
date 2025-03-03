package com.jobservice.service;


import com.jobservice.model.Job;
import com.jobservice.repository.JobRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired// automatic dependency injection
    private JobRepository jobRepository; //this fields holds an instance of JobRepository
    @Autowired
    private ModelMapper modelMapper; // this fields holds an instance of ModelMapper.

    public Job createNewJob(Job job) throws Exception{ //It takes Job object as a parameter
        return jobRepository.save(job); //then saves it to the database using the save() in the jobRepository and returns the saved job object.
    }


    public List<Job> getAllJobs() throws Exception{
        return jobRepository.findAll();
    } // This method retrieves all jobs from the database using the findAll() method in the jobRepository and returns a list of job objects.
    public List<Job> getJobsByCompanyId(int companyID) { // This method retrieves all Jobs by its company id using the findByCompanyId() in the jobRepository. .
        return jobRepository.findByCompanyId(companyID);
    }
    public Job updateJobByJobId(Job job) { // This method update an existing job. It takes Job object as its parameter.
        return jobRepository.save(job);
        // then saves it to the database using the save method provided by jobRepository and returns the updated job object.
    }

    public Optional<Job> getJobById(int jobID) { //This method retrieves a job by its id.
        return jobRepository.findById(jobID);
        // It invokes the findById() method of jobRepository and returns an 'optional' containing the found 'job' object.
    }


    public void deleteJobById(int jobID) { //This method deletes a job by its ID.
        jobRepository.deleteById(jobID);
        // It invokes the deleteById method of jobRepository to remove the job from the database.
    }
}