package com.springprojects.springproject1.service;

import com.springprojects.springproject1.entity.EmployeeEntity;
import com.springprojects.springproject1.repository.EmployeeRepository;
import com.springprojects.springproject1.representation.request.EmployeeRequest;
import com.springprojects.springproject1.representation.response.EmployeeResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Employee Service Implementation
 */
@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    /**
     * creating object of Employee Repository
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * method to get all the employee list
     *
     * @return list of employees
     */
    @Override
    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> all = employeeRepository.findAll();
//        List<EmployeeResponse> responses=new ArrayList<>();
//        for(EmployeeEntity entity:all){
//            responses.add(getResponse(entity));
//        }
        return all;
    }

    /**
     * method to get the employee details from the id
     *
     * @param employeeId
     * @return employee by id
     */
    @Override
    public EmployeeResponse getEmployee(long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        return getResponse(employeeEntity.get());

    }

    /**
     * mehtod to add the new employee
     *
     * @param
     * @return add new employee
     */
    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        employeeEntity.setEmail(employeeRequest.getMail());
        employeeEntity.setFirstName(employeeRequest.getFirstName());
        employeeEntity.setLastName(employeeRequest.getLastName());
        employeeRepository.save(employeeEntity);
        return getResponse(employeeEntity);
    }

    private EmployeeResponse getResponse(EmployeeEntity employeeEntity){
        EmployeeResponse employeeResponse=new EmployeeResponse();
        employeeResponse.setMail(employeeEntity.getEmail());
        employeeResponse.setFirstName(employeeEntity.getFirstName());
        employeeResponse.setLastName(employeeEntity.getLastName());
        employeeResponse.setId(employeeEntity.getId());
        employeeResponse.setUserName(employeeEntity.getFirstName()+" "+employeeEntity.getLastName());
        return employeeResponse;

    }
    /**
     * method to update the employee
     *
     * @param employeeEntity
     * @return updated employee
     */
    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
        return employeeEntity;
    }

    /**
     * method to delete the employee
     *
     * @param parseLong
     */
    @Override
    public void deleteEmployee(long parseLong) {
        EmployeeEntity enty = employeeRepository.getReferenceById(parseLong);
        employeeRepository.delete(enty);
    }
}
