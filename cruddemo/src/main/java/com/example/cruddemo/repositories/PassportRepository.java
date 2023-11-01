package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PassportRepository extends JpaRepository<Passport, Integer> {
    
    List<Passport> findBySeries(String series);
    
}
