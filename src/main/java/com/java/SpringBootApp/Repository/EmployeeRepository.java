package com.java.SpringBootApp.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.SpringBootApp.Entity.Designation;
import com.java.SpringBootApp.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDesignation(Designation designation);
    
    Page<Employee> findAll(Pageable pageable);
}
