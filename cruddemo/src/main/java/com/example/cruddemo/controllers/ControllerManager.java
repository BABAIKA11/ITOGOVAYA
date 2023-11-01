package com.example.cruddemo.controllers;

import com.example.cruddemo.models.*;
import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@org.springframework.stereotype.Controller
@PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
public class ControllerManager {

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
    public ControllerManager(PassportRepository passportRepository, RoleRepository roleRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository, IncomeRepository incomeRepository,
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


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newProduct")
    public String showAddProduct(Product product, Model model) {
        model.addAttribute("product", product);
        return "add-product";
    }


    @GetMapping("/editProduct/{id}")
    public String showUpdateProduct(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        model.addAttribute("manufacturer", manufacturerRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
        model.addAttribute("product", product);
        return "update-product";
    }


    @PostMapping("/addproduct")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        productRepository.save(product);
        return "redirect:/";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int id, @ModelAttribute("manufacturer") int manufacturers,  @ModelAttribute("storage") int storages, @Valid Product product, BindingResult result, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(manufacturers).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        Storage storage = storageRepository.findById(storages).orElseThrow(() -> new IllegalArgumentException("Invalid storage Id:" + id));
        product.setManufacturer(manufacturer);
        product.setStorage(storage);
        productRepository.save(product);
        model.addAttribute("product", productRepository.findAll());
        return "redirect:/";
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newManufacturer")
    public String showAddManufacter(Manufacturer manufacturer, Model model) {
        model.addAttribute("manufacturer", manufacturer);
        return "add-manufacturer";
    }


    @GetMapping("/editManufacturer/{id}")
    public String showUpdateManufacturer(@PathVariable("id") int id, Model model) {
        Manufacturer manufacturer = manufacturerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        model.addAttribute("manufacturer", manufacturer);
        return "update-manufacturer";
    }


    @PostMapping("/addmanufacturer")
    public String addManufacturer(@Valid Manufacturer manufacturer, BindingResult result, Model model) {
        manufacturerRepository.save(manufacturer);
        return "redirect:/";
    }

    @PostMapping("/updateManufacturer/{id}")
    public String updateManufacturer(@PathVariable("id") int id, @Valid Manufacturer manufacturer, BindingResult result, Model model) {
        manufacturerRepository.save(manufacturer);
        return "redirect:/";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newStorage")
    public String showAddStorage(Storage storage, Model model) {
        model.addAttribute("storage", storage);
        return "add-storage";
    }


    @GetMapping("/editStorage/{id}")
    public String showUpdateStorage(@PathVariable("id") int id, Model model) {
        Storage storage = storageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid storage Id:" + id));
        model.addAttribute("storage", storage);
        return "update-storage";
    }


    @PostMapping("/addstorage")
    public String addIncome(@Valid Storage storage, BindingResult result, Model model) {
        storageRepository.save(storage);
        return "redirect:/";
    }

    @PostMapping("/updateStorage/{id}")
    public String updateStorage(@PathVariable("id") int id, @Valid Storage storage, BindingResult result, Model model) {
        storageRepository.save(storage);
        return "redirect:/";
    }
}
