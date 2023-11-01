package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    
//    List<Customer> findByName(String name);
    
}
