package com.applicationservice.repository;

import com.applicationservice.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application,Integer > {
    Optional<Application> findByName(String fileName);
}
