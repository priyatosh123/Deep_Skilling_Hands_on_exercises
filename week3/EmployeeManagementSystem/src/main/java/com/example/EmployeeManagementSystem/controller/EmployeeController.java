package com.example.EmployeeManagementSystem.controller;
import com.example.EmployeeManagementSystem.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.entity.Department;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/dept/{deptId}")
    public ResponseEntity<Employee> createEmployee(@PathVariable Long deptId, @RequestBody Employee employee) {
    	Department dept = departmentRepository.findById(deptId)
    	        .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(dept);
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedDetails) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedDetails.getName());
            employee.setEmail(updatedDetails.getEmail());
            return ResponseEntity.ok(employeeRepository.save(employee));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    


    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String keyword) {
        return employeeRepository.searchEmployees(keyword);
    }

    @GetMapping("/department-name")
    public List<Employee> getByDeptName(@RequestParam String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    @GetMapping("/email-named")
    public ResponseEntity<Employee> getByEmailNamed(@RequestParam String email) {
        return ResponseEntity.ok(employeeRepository.findByEmailNamed(email));
    }
    @GetMapping("/paginated")
    public Page<Employee> getEmployeesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "") String nameFilter) {

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return employeeRepository.findByNameContaining(nameFilter, pageable);
    }
}