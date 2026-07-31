package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeBulkService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void saveAllEmployeesInBatches(List<Employee> employees) {
        // Thanks to our application properties configuration,
        // saving this collection invokes batch executions automatically.
        employeeRepository.saveAll(employees);
    }
}