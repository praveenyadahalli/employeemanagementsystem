package com.springprojects.springproject1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Employee Entity
 * <p>
 * Entity involves id, firstname, lastname, email_address
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeesnew")
public class EmployeeEntity {
    /**
     * This is id for Employee and it will mentioned as a primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "active")
    private boolean active;
    @Column(name = "dept")
    private String dept;
    /**
     * This the first_name field of Employee
     */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /**
     * This is last_name field of Employee
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * This is email_address field of Employee
     */
    @Column(name = "email_address", nullable = false)
    private String email;

}
