package com.ntsako.employeeService.mapper;

import com.ntsako.employeeService.dto.EmployeeDto;
import com.ntsako.employeeService.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		if (employee == null) {
			throw new NullPointerException("Null Employee object was supplied");
		}

		EmployeeDto employeeDTo = EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName())
				.lastName(employee.getLastName()).email(employee.getEmail()).build();

		return employeeDTo;
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		if (employeeDto == null) {
			throw new NullPointerException("Null EmployeeDTO object was supplied");
		}
		
		Employee employee = Employee.builder().id(employeeDto.getId()).firstName(employeeDto.getFirstName())
				.lastName(employeeDto.getLastName()).email(employeeDto.getEmail()).build();
		
		return employee;
	}

}
