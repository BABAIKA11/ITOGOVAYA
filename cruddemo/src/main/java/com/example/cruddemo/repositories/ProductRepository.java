package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Product;
import com.example.cruddemo.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    
   // List<Passport> findBySeries(String series);
    
}
