package com.accolite.employee.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Employee {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	  	
	  	@Column
	  	private String name;
	  	
	  	@Column
	  	private Integer age;
	  	
	  	@Column 
	  	private String designation;
	  	
	  	@Column 
	  	private Integer salary;
	  	
	    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    Task task;
	    
	    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	    Set<Department> department;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public Integer getSalary() {
			return salary;
		}

		public void setSalary(Integer salary) {
			this.salary = salary;
		}

		public Task getTask() {
			return task;
		}

		public void setTask(Task task) {
			this.task = task;
		}

		public Set<Department> getDepartment() {
			return department;
		}

		public void setDepartment(Set<Department> department) {
			this.department = department;
		}
	  
}
