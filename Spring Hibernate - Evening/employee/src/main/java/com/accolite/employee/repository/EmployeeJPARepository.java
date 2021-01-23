package com.accolite.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.accolite.employee.entity.Employee;

public interface EmployeeJPARepository extends CrudRepository<Employee,Integer> {
	public Employee findEmployeeByTask_Id(int id);

}
