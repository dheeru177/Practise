package com.smedia.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smedia.Entity.Employee;
import com.smedia.Repository.RepositoryJpa;
import com.smedia.Service.ServiceInterface;

@Service
public class ServiceImplementation implements ServiceInterface {
	
	@Autowired
	private RepositoryJpa repositoryJpa;

	@Override
	public Employee createEmployee(Employee employee) {
	
		Employee save = repositoryJpa.save(employee);
		
		
		return save;
	}

	@Override
	public List<Employee> getAlEmployees() {
	
		List<Employee> list = repositoryJpa.findAll();
		
		return list;
	}

	@Override
	public Employee getEmployeeById(Long Id) {
                Employee employee = repositoryJpa.findById(Id).orElseThrow(() -> new RuntimeException("Given Id cannot be found"));
		return employee;
	}

	@Override
	public Employee updateEmployee(Long Id, Employee employee) {
		  
		Employee employee2 = repositoryJpa.findById(Id).orElseThrow(() -> new RuntimeException("Given Id is not present in Db"));
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setDesignation(employee.getDesignation());
		repositoryJpa.save(employee2);
		
		return employee2;
	}

	@Override
	
	public String deleteEmployee(Long Id) {
		  
	Employee employee2 = repositoryJpa.findById(Id).orElseThrow(() -> new RuntimeException("Given Id is not present in Db"));
			repositoryJpa.deleteById(Id);
			
		return "Id deleted";
	}

}
