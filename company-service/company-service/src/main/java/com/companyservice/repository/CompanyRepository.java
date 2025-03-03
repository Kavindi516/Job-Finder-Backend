package com.companyservice.repository;

import com.companyservice.model.Company;
import com.companyservice.response.LoginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository // It marks the interface as a Spring Data repository which used to manage instances of the Company entity.
public interface CompanyRepository extends JpaRepository<Company, Integer> {         //it will handle operations related to the Company entity and its primary key is of type Integer.
   @Query(nativeQuery = true, value ="SELECT c.company_id FROM company c WHERE c.email= :email AND  c.password= :password")
   Object findByCredentials(@Param("email") String email, @Param("password") String password);
// It selects the company_id from the company table where the email and password match the provided parameters.
}
//The method returns an Object which may contain the result of the query. We use this method to get the company id.


//@Query: This is used to specify a custom JPQL (Java Persistence Query Language) or native SQL query to be executed when the corresponding method is called.
//
//nativeQuery = true: This attribute indicates that the provided query is a native SQL query rather than JPQL.

