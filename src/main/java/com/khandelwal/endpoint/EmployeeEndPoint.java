package com.khandelwal.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.khandelwal.employeeschema.GetEmployeeByIdRequest;
import com.khandelwal.employeeschema.GetEmployeeByIdResponse;
import com.khandelwal.service.EmployeeService;

@Endpoint
public class EmployeeEndPoint {

	@Autowired
	EmployeeService employeeService;

	@PayloadRoot(namespace = "http://www.khandelwal.com/EmployeeSchema", localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeByIdResponse getEmployeeById(@RequestPayload GetEmployeeByIdRequest getEmployeeByIdRequest)
			throws Exception {

		GetEmployeeByIdResponse getEmployeeByIdResponse = new GetEmployeeByIdResponse();
		getEmployeeByIdResponse.setEmployee(employeeService.getEmployeeById(getEmployeeByIdRequest));
		return getEmployeeByIdResponse;

	}
}
