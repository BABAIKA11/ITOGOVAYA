package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Client;
import com.example.cruddemo.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    
   // List<Passport> findBySeries(String series);
    
}
