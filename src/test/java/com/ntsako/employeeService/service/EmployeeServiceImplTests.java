//package com.ntsako.employeeService.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.ntsako.employeeService.EmployeeServiceApplication;
//import com.ntsako.employeeService.dto.EmployeeDto;
//import com.ntsako.employeeService.entity.Employee;
//import com.ntsako.employeeService.mapper.EmployeeMapper;
//import com.ntsako.employeeService.repository.EmployeeRepository;
//import com.ntsako.employeeService.service.impl.EmployeeServiceImpl;
//
//@SpringBootTest
//@ContextConfiguration(classes = EmployeeServiceApplication.class)
//public class EmployeeServiceImplTests {
//
//    @Mock
//    private EmployeeRepository employeeRepository;
//
//    @InjectMocks
//    private EmployeeServiceImpl employeeService;
//    
//    private static Employee employee;
//	private static Employee employee1;
//	
//	private static List<Employee> foundEmployees;
//    
//    private static EmployeeDto employeeDto;
//	private static EmployeeDto employeeDto1;
//
//	@BeforeAll
////	public static void setup(){
////		//Employee Data
////		employee = new Employee();
////        employee.setFirstName("Lets");
////        employee.setLastName("Mnisi");
////        employee.setEmail("Lest@gmail.com");
////        
////        employee1 = new Employee();
////        employee1.setFirstName("Andz");
////        employee1.setLastName("Mnisi");
////        employee1.setEmail("andz@gmail.com");
////        
////        foundEmployees = Arrays.asList(employee, employee1);
////        
////      //Employee Dto Data
////	    employeeDto = new EmployeeDto();
////	    employeeDto.setFirstName("Lets");
////	    employeeDto.setLastName("Mnisi");
////	    employeeDto.setEmail("Lest@gmail.com");
////        
////	    employeeDto1 = new EmployeeDto();
////	    employeeDto1.setFirstName("Andz");
////	    employeeDto1.setLastName("Mnisi");
////	    employeeDto1.setEmail("andz@gmail.com");
////	}
//
////    @Test
////    public void testCreateEmployee() {
////    	
////        Employee employee = EmployeeMapper.mapToEmployee(employeeDto1);
////       Employee savedEmployee = EmployeeMapper.mapToEmployee(employeeDto1);
////
////        when(employeeRepository.save(employee)).thenReturn(savedEmployee);
////
////        EmployeeDto result = employeeService.createEmployee(employeeDto1);
////
////        assertNotNull(result);
////        assertEquals(employeeDto1, result);
////
////        verify(employeeRepository, times(1)).save(employee);
////        verifyNoMoreInteractions(employeeRepository);
////    }
//
//    @Test
//    public void testGetEmployeeById() {
//        Long employeeId = 1L;
//   
//        EmployeeDto expectedEmployeeDto = EmployeeMapper.mapToEmployeeDto(employee);
//
//        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
//
//        EmployeeDto result = employeeService.getEmployeeById(employeeId);
//
//        assertEquals(expectedEmployeeDto, result);
//
//        verify(employeeRepository, times(1)).findById(employeeId);
//        verifyNoMoreInteractions(employeeRepository);
//    }
//
//    @Test
//    public void testGetAllEmployees() {
//   
//        List<EmployeeDto> expectedEmployeeDtos = Arrays.asList(
//                EmployeeMapper.mapToEmployeeDto(foundEmployees.get(0)),
//                EmployeeMapper.mapToEmployeeDto(foundEmployees.get(1))
//        );
//
//        when(employeeRepository.findAll()).thenReturn(foundEmployees);
//
//        List<EmployeeDto> result = employeeService.getAllEmployees();
//
//        assertEquals(expectedEmployeeDtos, result);
//
//        verify(employeeRepository, times(1)).findAll();
//        verifyNoMoreInteractions(employeeRepository);
//    }
//
//    @Test
//    public void testUpdateEmployee() {
//        Long employeeId = 1L;
//
//        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
//        when(employeeRepository.save(employee)).thenReturn(employee);
//
//        EmployeeDto result = employeeService.updateEmployee(employeeId, employeeDto);
//
//        assertEquals(employeeDto, result);
//
//        verify(employeeRepository, times(1)).findById(employeeId);
//        verify(employeeRepository, times(1)).save(employee);
//        verifyNoMoreInteractions(employeeRepository);
//    }
//
//    @Test
//    public void testDeleteEmployee() {
//        Long employeeId = 1L;
//
//        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));
//
//        employeeService.deleteEmployee(employeeId);
//
//        verify(employeeRepository, times(1)).findById(employeeId);
//        verify(employeeRepository, times(1)).delete(employee);
//        verifyNoMoreInteractions(employeeRepository);
//    }
//}
