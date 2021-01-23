package com.accolite.employee.entity;


import java.util.Set;

import javax.persistence.*;

@Entity
public class Department {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column
	private String name;
	
	@Column 
	private String workAreaa;
	
	@Column 
	private String managerName;
	
	@ManyToMany()
	Set<Employee> employee;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkAreaa() {
		return workAreaa;
	}

	public void setWorkAreaa(String workAreaa) {
		this.workAreaa = workAreaa;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	
	
}
