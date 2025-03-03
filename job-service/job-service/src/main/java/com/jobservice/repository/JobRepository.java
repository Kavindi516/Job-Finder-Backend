package com.jobservice.repository;

import com.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query(nativeQuery = true, value ="SELECT * FROM job j WHERE j.company_id= :companyId")
        //This query is used to select all the jobs from the job table where the company id  match the provided parameters.
    List<Job> findByCompanyId(@Param("companyId") int companyId); //This method returns all jobs as a list.
}
