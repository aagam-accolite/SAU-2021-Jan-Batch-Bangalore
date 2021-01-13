package com.example.au.couchbasedemo.controller;



import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
    EmployeeRepository employeeRepository;

	 @PostMapping("/Employee")
	    public Employee addEmployee(@RequestBody Employee newEmployee) {
	        return employeeRepository.save(newEmployee);
	    }
	 
	 @GetMapping("/Employee/{id}")
	    public Optional<Employee> getEmployee(@PathVariable String id) {
	        if (employeeRepository.existsById(id)) {
	            return employeeRepository.findById(id);
	        } else
	            return Optional.empty();
	    }
	 @GetMapping("/Employee/location/{location}")
	    public Employee  getEmployeeByLocation(@PathVariable String location) {
	       return (employeeRepository.findByLocation(location));
	    }
	 @GetMapping("/Employee/zipcode/{zipcode}")
	    public Employee getEmployeeByzipcode(@PathVariable String zipcode) {
	       return (employeeRepository.findByZipcode(zipcode));
	    }
}
