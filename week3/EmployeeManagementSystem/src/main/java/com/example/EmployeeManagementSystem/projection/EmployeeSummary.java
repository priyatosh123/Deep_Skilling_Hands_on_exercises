package com.example.EmployeeManagementSystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeSummary {
    String getName();
    String getEmail();
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getContactDetails();
}