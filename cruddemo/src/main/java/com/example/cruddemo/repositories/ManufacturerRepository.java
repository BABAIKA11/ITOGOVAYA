package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Client;
import com.example.cruddemo.models.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    
   // List<Passport> findBySeries(String series);
    
}
