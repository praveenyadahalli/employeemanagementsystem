package com.springprojects.springproject1.service;

import com.springprojects.springproject1.entity.EmployeeEntity;
import com.springprojects.springproject1.representation.request.EmployeeRequest;
import com.springprojects.springproject1.representation.response.EmployeeResponse;

import java.util.List;

/**
 * Employee Service
 * <p>
 * Employee service has 5 methods
 */
public interface EmployeeService {

    public List<EmployeeEntity> getAllEmployee();

    public EmployeeResponse getEmployee(long employeeId);

    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

    public void deleteEmployee(long parseLong);

}
