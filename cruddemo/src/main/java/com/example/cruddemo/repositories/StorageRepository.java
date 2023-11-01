package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Client;
import com.example.cruddemo.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StorageRepository extends JpaRepository<Storage, Integer> {
    
   // List<Passport> findBySeries(String series);
    
}
