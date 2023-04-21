package com.smedia.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.smedia.Entity.Employee;
import com.smedia.ServiceImpl.ServiceImplementation;

@RestController
@ResponseBody
@RequestMapping("/Employee")
public class EmployeeController {

	
	private ServiceImplementation serviceImplementation;
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		
		Employee createEmployee = serviceImplementation.createEmployee(employee);
		
		
		return new ResponseEntity<Employee>(createEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping
	public  ResponseEntity<List<Employee>>  getAllEmployees()
	{
		
		List<Employee> list = serviceImplementation.getAlEmployees();
		
		return  new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/{Id}")
	public  ResponseEntity<Employee>  getEmployeeById(@PathVariable Long Id)
	{
		 Employee employeeById = serviceImplementation.getEmployeeById(Id);
		
		return  new ResponseEntity<Employee>(employeeById,HttpStatus.OK);
		
		
	}
	
	@PutMapping("/{Id}")
	public  ResponseEntity<Employee>  updateEmployee(@PathVariable Long Id, @RequestBody Employee employee)
	{
	  Employee updateEmployee = serviceImplementation.updateEmployee(Id, employee);
		
		return  new ResponseEntity<Employee>(updateEmployee,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{Id}")
	public  ResponseEntity<String>  deleteEmployee(@PathVariable Long Id)
	{
      String deleteEmployee = serviceImplementation.deleteEmployee(Id);
		
		return  new ResponseEntity<String>(deleteEmployee,HttpStatus.OK);
		
		
	}

}
