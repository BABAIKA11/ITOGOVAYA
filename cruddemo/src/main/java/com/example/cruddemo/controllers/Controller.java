package com.example.cruddemo.controllers;

import javax.validation.Valid;

import com.example.cruddemo.models.*;
import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@org.springframework.stereotype.Controller
public class Controller {
    
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
    public Controller(PassportRepository passportRepository, RoleRepository roleRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository, IncomeRepository incomeRepository,
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

    @GetMapping("/registration")
    private String RegView()
    {
        return "regis";
    }
    @PostMapping("/registration")
    private String Reg(modelUser user, Model model)
    {
        modelUser user_from_db = usersRepository.findByUsername(user.getUsername());
        if (user_from_db != null)
        {
            model.addAttribute("message", "Пользователь с таким логином уже существует");
            return "regis";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(roleEnum.MANAGER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "redirect:/login";
    }


    @GetMapping()
    public String index(Model model) {
        if(searchstring.equals(""))
        {
            model.addAttribute("passport", passportRepository.findAll());
        }
        else
        {
            model.addAttribute("passport", passportRepository.findBySeries(searchstring));
        }
        model.addAttribute("role", roleRepository.findAll());
        model.addAttribute("client", clientRepository.findAll());
        model.addAttribute("employee", employeeRepository.findAll());
        model.addAttribute("product", productRepository.findAll());
        model.addAttribute("manufacturer", manufacturerRepository.findAll());
        model.addAttribute("income", incomeRepository.findAll());
        model.addAttribute("storage", storageRepository.findAll());
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("searchstr") String searchstr) {
        searchstring = searchstr;
        return "redirect:/";
    }

    @GetMapping("/new/{id}")
    public String showSignUpForm(Passport passport, @PathVariable("id") int id, Model model) {
        model.addAttribute("passport", passport);
        model.addAttribute("id", id);
        return "add-passport";
    }

    @PostMapping("/addpassport")
    public String addPassport(@Valid Passport passport, @Valid Employee employee, BindingResult result, Model model) {
        employee.setPassport(passport);
        passport.setOwner(employee);
        passportRepository.save(passport);
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Passport passport = passportRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid passport Id:" + id));
        model.addAttribute("passport", passport);
        return "update-passport";
    }



    @PostMapping("/update/{id}")
    public String updatePassport(@PathVariable("id") int id, @Valid Passport passport, BindingResult result, Model model) {
        passportRepository.save(passport);
        return "redirect:/";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newRole")
    public String showAddRole(Role role, Model model) {
        model.addAttribute("role", role);
        return "add-role";
    }


    @GetMapping("/editRole/{id}")
    public String showUpdateRole(@PathVariable("id") int id, Model model) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        model.addAttribute("role", role);
        return "update-role";
    }



    @PostMapping("/addrole")
    public String addRole(@Valid Role role, BindingResult result, Model model) {
        roleRepository.save(role);
        return "redirect:/";
    }

    @PostMapping("/updateRole/{id}")
    public String updateRole(@PathVariable("id") int id, @Valid Role role, BindingResult result, Model model) {
        roleRepository.save(role);
        return "redirect:/";
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newEmployee")
    public String showAddEmployee(Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "add-employee";
    }


    @GetMapping("/editEmployee/{id}")
    public String showUpdateEmployee(@PathVariable("id") int id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        model.addAttribute("employee", employee);
        return "update-employee";
    }



    @PostMapping("/addemployee")
    public String addEmployee(@Valid Employee employee, @Valid Passport passport, BindingResult result, Model model) {
        employeeRepository.save(employee);
        passport.setId(employee.getId());
        passportRepository.save(passport);
        return "redirect:/";
    }

    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, @Valid Employee employee, BindingResult result, Model model) {
        employeeRepository.save(employee);
        return "redirect:/";
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newClient")
    public String showAddClient(Client client, Model model) {
        model.addAttribute("client", client);
        return "add-client";
    }


    @GetMapping("/editClient/{id}")
    public String showUpdateClient(@PathVariable("id") int id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "update-client";
    }



    @PostMapping("/addclient")
    public String addClient(@Valid Client client, BindingResult result, Model model) {
        clientRepository.save(client);
        return "redirect:/";
    }

    @PostMapping("/updateClient/{id}")
    public String updateClient(@PathVariable("id") int id, @Valid Client client, BindingResult result, Model model) {
        clientRepository.save(client);
        return "redirect:/";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping("/newIncome")
    public String showAddIncome(Income income, Model model) {
        model.addAttribute("income", income);
        return "add-income";
    }


    @GetMapping("/editIncome/{id}")
    public String showUpdateIncome(@PathVariable("id") int id, Model model) {
        Income income = incomeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid income Id:" + id));
        model.addAttribute("income", income);
        return "update-income";
    }


    @PostMapping("/addincome")
    public String addIncome(@Valid Income income, BindingResult result, Model model) {
        incomeRepository.save(income);
        return "redirect:/";
    }

    @PostMapping("/updateIncome/{id}")
    public String updateIncome(@PathVariable("id") int id, @Valid Income income, BindingResult result, Model model) {
        incomeRepository.save(income);
        return "redirect:/";
    }



}
