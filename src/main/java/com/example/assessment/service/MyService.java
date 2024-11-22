package com.example.assessment.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

// Question 4: MyService
// Here, we apply the @PreAuthorize annotation at the class level to enforce the rule across all methods in the class.
// In this example, both method1 and method2 inherit the @PreAuthorize condition from the class.
// This will help to remove redundancy by avoiding repeated annotations on individual methods.
@Service
@PreAuthorize("hasRole('ROLE_USER')") // Applies to all methods in this class
public class MyService {

    public void method1() {
        // Accessible only to users with ROLE_USER
        System.out.println("Method 1 executed.");
    }

    public void method2() {
        // Accessible only to users with ROLE_USER
        System.out.println("Method 2 executed.");
    }
}
