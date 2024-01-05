package com.ntsako.employeeService.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ntsako.employeeService.dto.EmployeeDto;
import com.ntsako.employeeService.entity.Employee;
import com.ntsako.employeeService.exception.ResourceNotFoundException;
import com.ntsako.employeeService.mapper.EmployeeMapper;
import com.ntsako.employeeService.repository.EmployeeRepository;
import com.ntsako.employeeService.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given Id: " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(foundEmployee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> foundEmployees = employeeRepository.findAll();
		return foundEmployees.stream().map((foundEmployee) -> EmployeeMapper.mapToEmployeeDto(foundEmployee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
		Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given Id: " + employeeId));
		foundEmployee.setFirstName(employeeDto.getFirstName());
		foundEmployee.setLastName(employeeDto.getLastName());
		foundEmployee.setEmail(employeeDto.getEmail());
		Employee updatedEmployee = employeeRepository.save(foundEmployee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee foundEmployee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given Id: " + employeeId));
		employeeRepository.delete(foundEmployee);

	}

}
