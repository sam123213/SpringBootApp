package com.java.SpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringBootApp.Entity.Designation;
import com.java.SpringBootApp.Entity.Employee;
import com.java.SpringBootApp.Entity.Salary;
import com.java.SpringBootApp.Repository.SalaryRepository;
import com.java.SpringBootApp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	
	@Autowired
    EmployeeService employeeService;
	
	@Autowired
	SalaryRepository salaryRepository;
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/designation/{designation}")
    public List<Employee> getByDesignation(@PathVariable Designation designation) {
        return employeeService.getEmployeesByDesignation(designation);
    }
    
    @GetMapping("/by-salary-range")
    public List<Employee> getEmployeesBySalaryRange(
            @RequestParam Double min,
            @RequestParam Double max) {

        return salaryRepository.findByAmountBetween(min, max)
                         .stream()
                         .map(Salary::getEmployee)
                         .toList();
    }
    
    @GetMapping("/paginated")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        return employeeService.findAll(pageable);
    }
    
}

