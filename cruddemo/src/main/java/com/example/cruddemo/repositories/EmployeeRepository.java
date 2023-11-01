package com.example.cruddemo.repositories;


import com.example.cruddemo.models.Client;
import com.example.cruddemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByMail(String mail);

}
