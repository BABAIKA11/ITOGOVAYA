package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Client;
import com.example.cruddemo.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IncomeRepository extends JpaRepository<Income, Integer> {
    
   // List<Passport> findBySeries(String series);
    
}
