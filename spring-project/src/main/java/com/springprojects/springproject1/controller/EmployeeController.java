package com.springprojects.springproject1.controller;

import com.springprojects.springproject1.entity.EmployeeEntity;
import com.springprojects.springproject1.exception.ResourceNotFoundException;
import com.springprojects.springproject1.representation.request.EmployeeRequest;
import com.springprojects.springproject1.representation.response.EmployeeResponse;
import com.springprojects.springproject1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Employee Controller
 * <p>
 * Rest Api for Employee Database
 */
@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Get mapping for employee list
     *
     * @return employee list
     */
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeService.getAllEmployee();
        return new ResponseEntity<List<EmployeeEntity>>(employeeEntities, HttpStatus.OK);
    }


    /**
     * get mapping for single employee by id
     *
     * @param employeeId
     * @return single employee
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable String employeeId) throws ResourceNotFoundException {
        EmployeeResponse employeeResponse = employeeService.getEmployee(Long.parseLong(employeeId));
        return new ResponseEntity<EmployeeResponse>(employeeResponse, HttpStatus.OK);
    }

    /**
     * post mapping for employee
     *
     * @param employeeEntity
     * @return add new employee
     */
    @PostMapping
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest employeeEntity) {
        EmployeeResponse employeeEntity1 = employeeService.addEmployee(employeeEntity);
        return new ResponseEntity<>(employeeEntity1, HttpStatus.CREATED);
    }


    /**
     * put mapping for employee
     *
     * @param employeeEntity
     * @return updated employee
     */
    @PutMapping
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        EmployeeEntity employeeEntity1 = employeeService.updateEmployee(employeeEntity);
        return new ResponseEntity<>(employeeEntity1, HttpStatus.CREATED);
    }


    /**
     * delete mapping for employee
     *
     * @param employeeId
     * @return delete employee
     */
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable String employeeId) {
        try {
            employeeService.deleteEmployee(Long.parseLong(employeeId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
