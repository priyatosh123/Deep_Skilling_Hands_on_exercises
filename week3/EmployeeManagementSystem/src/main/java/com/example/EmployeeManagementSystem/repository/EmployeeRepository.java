package com.example.EmployeeManagementSystem.repository;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.projection.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	// Derived Query Method
    List<Employee> findByDepartmentName(String deptName);

    // Custom JPQL Query (For Exercise 5)
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:keyword% OR e.email LIKE %:keyword%")
    List<Employee> searchEmployees(@Param("keyword") String keyword);

    // Named Query Target (For Exercise 5)
    Employee findByEmailNamed(@Param("email") String email);

    // Paginated Search (For Exercise 6)
    Page<Employee> findByNameContaining(String name, Pageable pageable);
    List<EmployeeSummary> findProjectedByDepartmentName(String deptName);

}
