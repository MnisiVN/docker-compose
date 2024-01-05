//package com.ntsako.employeeService.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.ntsako.employeeService.dto.EmployeeDto;
//import com.ntsako.employeeService.service.EmployeeService;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class EmployeeControllerTests {
//
//	@Mock
//	private EmployeeService employeeService;
//
//	@InjectMocks
//	private EmployeeController employeeController;
//	
//	private static EmployeeDto employee;
//	private static EmployeeDto employee1;
//	
//	private static List<EmployeeDto> foundEmployees;
//
//	@BeforeAll
//	public static void setup(){
//	    employee = new EmployeeDto();
//        employee.setFirstName("Lets");
//        employee.setLastName("Mnisi");
//        employee.setEmail("Lest@gmail.com");
//        
//        employee1 = new EmployeeDto();
//        employee1.setFirstName("Andz");
//        employee1.setLastName("Mnisi");
//        employee1.setEmail("andz@gmail.com");
//        
//        foundEmployees = Arrays.asList(employee, employee1);
//	}
//	
//	@Test
//    public void testCreateEmployee() {
//
//        when(employeeService.createEmployee(employee)).thenReturn(employee);
//
//        ResponseEntity<EmployeeDto> responseEntity = employeeController.createEmployee(employee);
//
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertEquals(employee, responseEntity.getBody());
//
//        verify(employeeService, times(1)).createEmployee(employee);
//        verifyNoMoreInteractions(employeeService);
//    }
//	
//	@Test
//    public void testGetEmployeeById() {
//        Long employeeId = 1L;
//
//        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);
//
//        ResponseEntity<EmployeeDto> responseEntity = employeeController.getEmployeeById(employeeId);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(employee, responseEntity.getBody());
//
//        verify(employeeService, times(1)).getEmployeeById(employeeId);
//        verifyNoMoreInteractions(employeeService);
//    }
//
//    @Test
//    public void testGetAllEmployees() {
//
//        when(employeeService.getAllEmployees()).thenReturn(foundEmployees);
//
//        ResponseEntity<List<EmployeeDto>> responseEntity = employeeController.getAllEmployees();
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(foundEmployees, responseEntity.getBody());
//
//        verify(employeeService, times(1)).getAllEmployees();
//        verifyNoMoreInteractions(employeeService);
//    }
//
//    @Test
//    public void testUpdateEmployee() {
//        Long employeeId = 1L;
// 
//        when(employeeService.updateEmployee(employeeId, employee)).thenReturn(employee);
//
//        ResponseEntity<EmployeeDto> responseEntity = employeeController.updateEmployee(employeeId, employee);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals(employee, responseEntity.getBody());
//
//        verify(employeeService, times(1)).updateEmployee(employeeId, employee);
//        verifyNoMoreInteractions(employeeService);
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//        Long employeeId = 1L;
//
//        ResponseEntity<String> responseEntity = employeeController.deleteEmployee(employeeId);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        assertEquals("Employee deleted successfully. ", responseEntity.getBody());
//
//        verify(employeeService, times(1)).deleteEmployee(employeeId);
//        verifyNoMoreInteractions(employeeService);
//    }
//
//}
