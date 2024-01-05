//package com.ntsako.employeeService.service.integration;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.ntsako.employeeService.dto.EmployeeDto;
//import com.ntsako.employeeService.entity.Employee;
//import com.ntsako.employeeService.repository.EmployeeRepository;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class EmployeeIntegrationTests {
//
//	@LocalServerPort
//	private int port;
//
//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Autowired
//	private EmployeeRepository employeeRepository;
//
//	private static EmployeeDto employeeDto;
//
//	private static Employee employee;
//	private static Employee employee1;
//
//	@TestConfiguration
//	static class TestConfig {
//
//	}
//
//	@BeforeEach
//	public void setUp() {
//		employeeRepository.deleteAll();
//	}
//
//	@Test
//	public void testCreateEmployee() {
//
//		employeeDto = new EmployeeDto();
//		employeeDto.setFirstName("Create");
//		employeeDto.setLastName("Mnisi");
//		employeeDto.setEmail("Create@gmail.com");
//
//		ResponseEntity<EmployeeDto> response = restTemplate.postForEntity("/api/employees", employeeDto,
//				EmployeeDto.class);
//
//		assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//		Long createdEmployeeId = response.getBody().getId();
//		Employee createdEmployee = employeeRepository.findById(createdEmployeeId).orElse(null);
//		assertNotNull(createdEmployee);
//		assertEquals(employeeDto.getFirstName(), createdEmployee.getFirstName());
//		assertEquals(employeeDto.getLastName(), createdEmployee.getLastName());
//		assertEquals(employeeDto.getEmail(), createdEmployee.getEmail());
//	}
//
//	@Test
//	public void testGetEmployeeById() {
//
//		employee = new Employee();
//		employee.setFirstName("FindBy");
//		employee.setLastName("Mnisi");
//		employee.setEmail("FindBy@gmail.com");
//
//		Employee savedEmployee = employeeRepository.save(employee);
//
//		ResponseEntity<EmployeeDto> response = restTemplate.getForEntity("/api/employees/{id}", EmployeeDto.class,
//				savedEmployee.getId());
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(savedEmployee.getFirstName(), response.getBody().getFirstName());
//		assertEquals(savedEmployee.getLastName(), response.getBody().getLastName());
//		assertEquals(savedEmployee.getEmail(), response.getBody().getEmail());
//	}
//
//	@Test
//	public void testGetAllEmployees() {
//
//		employee = new Employee();
//		employee.setFirstName("Lethecia");
//		employee.setLastName("Mnisi");
//		employee.setEmail("Lethecia@gmail.com");
//
//		employee1 = new Employee();
//		employee1.setFirstName("Andzani");
//		employee1.setLastName("Mnisi");
//		employee1.setEmail("andzani@gmail.com");
//
//		Employee savedEmployee1 = employeeRepository.save(employee);
//		Employee savedEmployee2 = employeeRepository.save(employee1);
//
//		ResponseEntity<EmployeeDto[]> response = restTemplate.getForEntity("/api/employees", EmployeeDto[].class);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//
//		EmployeeDto[] employees = response.getBody();
//		assertNotNull(employees);
//		assertEquals(2, employees.length);
//
//		assertEquals(savedEmployee1.getFirstName(), employees[0].getFirstName());
//		assertEquals(savedEmployee1.getLastName(), employees[0].getLastName());
//		assertEquals(savedEmployee1.getEmail(), employees[0].getEmail());
//
//		assertEquals(savedEmployee2.getFirstName(), employees[1].getFirstName());
//		assertEquals(savedEmployee2.getLastName(), employees[1].getLastName());
//		assertEquals(savedEmployee2.getEmail(), employees[1].getEmail());
//	}
//
//	@Test
//	public void testUpdateEmployee() {
//
//		employee = new Employee();
//		employee.setFirstName("Update");
//		employee.setLastName("Mnisi");
//		employee.setEmail("Update@gmail.com");
//
//		Employee savedEmployee = employeeRepository.save(employee);
//
//		employeeDto = new EmployeeDto();
//		employeeDto.setFirstName("Updated");
//		employeeDto.setLastName("Mnisi");
//		employeeDto.setEmail("Updated@gmail.com");
//
//		ResponseEntity<EmployeeDto> response = restTemplate.exchange("/api/employees/{id}", HttpMethod.PUT,
//				new HttpEntity<>(employeeDto), EmployeeDto.class, savedEmployee.getId());
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//
//		EmployeeDto updatedEmployee = response.getBody();
//		assertNotNull(updatedEmployee);
//
//		assertEquals(employeeDto.getFirstName(), updatedEmployee.getFirstName());
//		assertEquals(employeeDto.getLastName(), updatedEmployee.getLastName());
//		assertEquals(employeeDto.getEmail(), updatedEmployee.getEmail());
//
//		Employee updatedEntity = employeeRepository.findById(savedEmployee.getId()).orElse(null);
//		assertNotNull(updatedEntity);
//		assertEquals(employeeDto.getFirstName(), updatedEntity.getFirstName());
//		assertEquals(employeeDto.getLastName(), updatedEntity.getLastName());
//		assertEquals(employeeDto.getEmail(), updatedEntity.getEmail());
//	}
//
//	@Test
//	public void testDeleteEmployeeById() {
//
//		employee = new Employee();
//		employee.setFirstName("Delete");
//		employee.setLastName("Mnisi");
//		employee.setEmail("Delete@gmail.com");
//
//		Employee savedEmployee = employeeRepository.save(employee);
//
//		ResponseEntity<Void> response = restTemplate.exchange("/api/employees/{id}", HttpMethod.DELETE, null,
//				Void.class, savedEmployee.getId());
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//
//		assertFalse(employeeRepository.existsById(savedEmployee.getId()));
//	}
//
//}
