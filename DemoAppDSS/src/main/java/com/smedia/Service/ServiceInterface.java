package com.smedia.Service;

import java.util.List;

import com.smedia.Entity.Employee;

public interface ServiceInterface {
	
	//create Employee
	public Employee createEmployee(Employee employee);
	
	//get All Employees
	public List<Employee> getAlEmployees();
	
	//get Employee by Id
	public Employee getEmployeeById(Long Id);
	
	
	//Update Employee
	public Employee updateEmployee(Long Id, Employee employee);
	
	//delete Employee
	public String deleteEmployee(Long Id);
	
	

}
