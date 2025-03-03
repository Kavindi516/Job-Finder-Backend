package com.jobSeekerservice.repository;

import com.jobSeekerservice.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {
    @Query(nativeQuery = true, value ="SELECT js.job_seeker_id FROM job_seeker js WHERE js.email= :email AND  js.password= :password")
    Object findByCredentials(@Param("email") String email, @Param("password") String password);
}
