package com.example.cruddemo.controllers;

import com.example.cruddemo.models.*;
import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;

@org.springframework.stereotype.Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class ControllerAdmin {

    private final PassportRepository passportRepository;
    private final RoleRepository roleRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final IncomeRepository incomeRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;
    private final StorageRepository storageRepository;
    private final userRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private String searchstring = "";

    @Autowired
    public ControllerAdmin(PassportRepository passportRepository, RoleRepository roleRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository, IncomeRepository incomeRepository,
                           ManufacturerRepository manufacturerRepository, ProductRepository productRepository, StorageRepository storageRepository, userRepository usersRepository) {
        this.passportRepository = passportRepository;
        this.roleRepository = roleRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.incomeRepository = incomeRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
        this.storageRepository = storageRepository;
        this.usersRepository = usersRepository;
    }



    @GetMapping("/delete/{id}")
    public String deletePassport(@PathVariable("id") int id, Model model) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid passport Id:" + id));
        passportRepository.delete(passport);
        model.addAttribute("passports", passportRepository.findAll());
        return "redirect:/";
    }



    @GetMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id, Model model) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        roleRepository.delete(role);
        model.addAttribute("roles", roleRepository.findAll());
        return "redirect:/";
    }


    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
        model.addAttribute("employees", employeeRepository.findAll());
        return "redirect:/";
    }


    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        productRepository.delete(product);
        model.addAttribute("products", productRepository.findAll());
        return "redirect:/";
    }


    @GetMapping("/deleteManufacturer/{id}")
    public String deleteManufacturer(@PathVariable("id") int id, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        manufacturerRepository.delete(manufacturer);
        model.addAttribute("manufacturer", manufacturerRepository.findAll());
        return "redirect:/";
    }

    @GetMapping("/deleteIncome/{id}")
    public String deleteIncome(@PathVariable("id") int id, Model model) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid income Id:" + id));
        incomeRepository.delete(income);
        model.addAttribute("income", incomeRepository.findAll());
        return "redirect:/";
    }

    @GetMapping("/deleteStorage/{id}")
    public String deleteStorage(@PathVariable("id") int id, Model model) {
        Storage storage = storageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid storage Id:" + id));
        storageRepository.delete(storage);
        model.addAttribute("storage", storageRepository.findAll());
        return "redirect:/";
    }
}
