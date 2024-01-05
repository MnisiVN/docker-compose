package com.ntsako.employeeService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
}
