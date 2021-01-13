package com.example.au.couchbasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,String> {

	Employee findByLocation(String location);
	
	Employee findByZipcode(String zipcode);
}
