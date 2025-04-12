package com.java.SpringBootApp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.java.SpringBootApp.Entity.Designation;
import com.java.SpringBootApp.Entity.Employee;
import com.java.SpringBootApp.Repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesByDesignation(Designation designation) {
        return employeeRepository.findByDesignation(designation);
    }

	public List<Employee> getAllEmployees() 
	{
		return employeeRepository.findAll();
	}

	public Page<Employee> findAll(org.springframework.data.domain.Pageable pageable) 
	{
		return employeeRepository.findAll(pageable);
	}
}
