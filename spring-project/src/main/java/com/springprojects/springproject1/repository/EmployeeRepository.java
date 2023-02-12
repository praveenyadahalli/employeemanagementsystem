package com.springprojects.springproject1.repository;

import com.springprojects.springproject1.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee Repository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
