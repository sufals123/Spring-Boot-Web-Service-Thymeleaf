package com.boot.springrestjpa.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.boot.springrestjpa.Model.Emp;
import com.boot.springrestjpa.Services.EmpService;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // Get all employees
    @GetMapping("/emp")
    public ResponseEntity<List<Emp>> getAllEmployees() {
        List<Emp> employees = empService.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(employees);
    }

    // Get employee by ID
    @GetMapping("/emp/{id}")
    public ResponseEntity<Emp> getEmployeeById(@PathVariable int id) {
        Emp emp = empService.getEmployeeById(id);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create new employee
    @PostMapping("/emp")
    public ResponseEntity<Emp> createEmployee(@RequestBody Emp emp) {
        Emp createdEmp = empService.createEmployee(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmp);
    }

    // Update existing employee
    @PutMapping("/emp/{id}")
    public ResponseEntity<Emp> updateEmployee(@PathVariable int id, @RequestBody Emp updatedEmp) {
        Emp emp = empService.updateEmployee(id, updatedEmp);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete employee
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        empService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}


//create database SpringBoot
//use Postman
//change your spring DataSource property UserName && password