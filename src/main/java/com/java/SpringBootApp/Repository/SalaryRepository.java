package com.java.SpringBootApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SpringBootApp.Entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Integer> {

    List<Salary> findByAmountBetween(Double min, Double max);
}

