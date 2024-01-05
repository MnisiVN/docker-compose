package com.ntsako.employeeService.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntsako.employeeService.dto.EmployeeDto;
import com.ntsako.employeeService.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeRequest) {
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeRequest);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long employeeId) {
		EmployeeDto foundEmployee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<EmployeeDto>(foundEmployee, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		List<EmployeeDto> foundEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(foundEmployees, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long employeeId,
			@RequestBody EmployeeDto employeeRequest) {
		EmployeeDto foundEmployee = employeeService.updateEmployee(employeeId, employeeRequest);
		return new ResponseEntity<EmployeeDto>(foundEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String> ("Employee deleted successfully. ", HttpStatus.OK);
	}

}
