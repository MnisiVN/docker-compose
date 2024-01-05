package com.ntsako.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntsako.employeeService.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
