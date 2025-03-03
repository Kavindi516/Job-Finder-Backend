package com.jobservice.controller;

import com.jobservice.model.Job;
import com.jobservice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // Allow requests from frontend ,
//      allowing requests from the specified origin (http://localhost:5173 in this case) to access resources from this controller.
@RestController
@RequestMapping(path = "/job-service/api")
public class JobController {

    @Autowired //This annotation shows the automatic dependency injection.
    private JobService jobService; //This fields holds an instance of a JobService

    @PostMapping(path = "/jobs") //It maps HTTP POST request to /job-service/api/jobs
    public ResponseEntity<Job> createNewCompany(@RequestBody Job job) throws Exception{
        //This method create a new job by invoking the createNewJob method of Job service.
        System.out.println("New Job created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.createNewJob(job));
    } //It returns a ResponseEntity with the created job object and an HTTP status of 201 CREATED.

    //Get all jobs
    @GetMapping(path = "/jobs")//It maps the HTTP GET request to /job-service/api/jobs
    public ResponseEntity<List<Job>> getAllJobs() throws Exception{
        //This method retrieves all jobs by invoking the getAllJobs() in the JobService.
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getAllJobs());
    }//It returns a ResponseEntity WITH THE LIST OF ALL JOBS and an HTTP status of 200 ok.

    //Display all jobs which created by given company
    @GetMapping(path = "/job-list/{companyID}")
    // It maps HTTP GET requests to /job-service/api/job-list/{companyID} where company id is a path variable.
    public ResponseEntity<List<Job>> getJobsByCompanyId(@PathVariable int companyID) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getJobsByCompanyId(companyID));
    }//It returns a ResponseEntity WITH THE LIST OF ALL JOBS associated with a specific company id and an HTTP status of 200 ok.

    //Get job by Id for update
    @GetMapping(path = "/job/{jobID}") //It maps  HTTP GET requests to /job-service/api/job/{jobID}, Here jobID we use as a path variable
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable int jobID){
        //This method retrieves a Job details by its ID using the getJobById method of JobService
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getJobById(jobID));
    }//It returns a ResponseEntity containing an Optional with the job object and an HTTP status of 200 OK.

    //Update job
    @PutMapping(path = "/job/updateJob") // It maps HTTP PUT requests to /job-service/api/job/updateJob. It handles the update of an existing job
    public ResponseEntity<Job> updateJobByJobId(@RequestBody Job job){ //This method updates an existing job by invoking the updateJobByJobId method of jobService.
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.updateJobByJobId(job)); //It returns a ResponseEntity with the updated job object and an HTTP status of 201 CREATED.
    }

    //Delete selected job
    @DeleteMapping(path = "/job/{jobID}") //It maps DELETE HTTP request to /job-service/api/job/{jobID}, here {jobID} we use as a path variable.
    public void deleteJobById(@PathVariable int jobID){// this method deletes a job by its id by invoking the deleteJobById method of jobService.

        jobService.deleteJobById(jobID);
    }

}
