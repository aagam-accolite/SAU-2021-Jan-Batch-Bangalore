package com.accolite.employee;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accolite.employee.entity.Department;
import com.accolite.employee.entity.Employee;
import com.accolite.employee.entity.Task;
import com.accolite.employee.repository.EmployeeJPARepository;
import com.accolite.employee.repository.EmployeeRepository;

@SpringBootApplication
@Transactional
public class EmployeeApplication implements CommandLineRunner {

	 @Resource
	 EmployeeRepository employeeRepository;
	 
	 @Autowired
	 EmployeeJPARepository employeeJPARepository;
	 
	 public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	 public void run(String args[]) throws Exception {
		 
		 Task task = new Task();
		 
		 Employee employee = new Employee();
		 
		 Department department = new Department();
		 
		 task.setDescription("Task 1");
		 task.setDeadline(new Date(System.currentTimeMillis()));
		 
		 department.setName("Information Technology");
		 department.setWorkAreaa("SDE");
		 department.setManagerName("Demo Manager 1");
		 
		 Set<Department> departmentSet = new HashSet<Department>();
		 departmentSet.add(department);
		 
		 employee.setName("Aagam");
		 employee.setDesignation("Intern");
		 employee.setAge(21);
		 employee.setSalary(20000);
		 employee.setDepartment(departmentSet);
		 employee.setTask(task);
		 
		 task.setEmployee(employee);
		 Set<Employee> employeeSet = new HashSet<Employee>();
		 employeeSet.add(employee);
		 department.setEmployee(employeeSet );
		 
		 // Insert in Database
		 employeeJPARepository.save(employee);
		 System.out.println("Data Inserted in Database");
		 
		 
		 // Delete from Database
		 //employeeJPARepository.delete(employee);
		 //System.out.println("Data Removed in Database");
		 
		 // Find Employee by ID
		 Employee res = employeeJPARepository.findEmployeeByTask_Id(1);
		 System.out.println("Name of Employee" + res.getName());
		 System.out.println("Age of Employee" + res.getAge());
		 System.out.println("Salary of Employee" + res.getSalary());
		 
		 // Find All Employee
		 System.out.println(employeeJPARepository.findAll());
	 }

}
