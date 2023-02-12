package com.springprojects.springproject1;

import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot mini project
 * <p>
 * Spring boot project of employee details
 *
 * @author praveen
 * @version 1.0
 */
@NoArgsConstructor
@SpringBootApplication
public class SpringProjectApplication {


    /**
     * Main method of Spring project
     *
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(SpringProjectApplication.class, args);
    }
}
