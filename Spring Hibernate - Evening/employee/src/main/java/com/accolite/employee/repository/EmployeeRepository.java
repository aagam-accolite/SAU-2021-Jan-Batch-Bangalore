package com.accolite.employee.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.accolite.employee.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 // Create 
	 public void addEmployee(Employee employee)
	 {
		 	System.out.println("In Employee Addition Class");
	        entityManager.persist(employee);
	 }
	 
	 // Delete
	 public void removeEmployee(Employee employee)
	 {
		 System.out.println("In Delete method");
		 entityManager.remove(employee);
		 System.out.println("Deletio done");
	 }
	 
	 // Update
	 public Employee updateEmployee(Employee employee){
	        return entityManager.merge(employee);
	    }
	 // Read
	 public Employee getEmployeeById(int id){
	        return entityManager.find(Employee.class, id);
	    }
	 
	 

}
