package com.khandelwal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.khandelwal.employeeschema.Employee;
import com.khandelwal.employeeschema.GetEmployeeByIdRequest;

@Service
public class EmployeeService {

	private Map<String, Employee> employeeMap;

	public EmployeeService() {

		Employee firstEmployee = new Employee();
		firstEmployee.setName("Abhishek");
		firstEmployee.setDesignation("Architect");
		firstEmployee.setDepartment("IT");

		Employee secondEmployee = new Employee();
		secondEmployee.setName("Tarun");
		secondEmployee.setDesignation("Senior Developer");
		secondEmployee.setDepartment("IT");

		Employee thirdEmployee = new Employee();
		thirdEmployee.setName("Amol");
		thirdEmployee.setDesignation("Senior Manager");
		thirdEmployee.setDepartment("Sales");

		employeeMap = new HashMap<String, Employee>();
		employeeMap.put("001", firstEmployee);
		employeeMap.put("002", secondEmployee);
		employeeMap.put("003", thirdEmployee);
	}

	public Employee getEmployeeById(GetEmployeeByIdRequest getEmployeeByIdRequest) throws Exception {

		if (employeeMap.containsKey(getEmployeeByIdRequest.getId())) {
			return employeeMap.get(getEmployeeByIdRequest.getId());
		} else {
			throw new Exception("Employee not found");
		}
	}

}
