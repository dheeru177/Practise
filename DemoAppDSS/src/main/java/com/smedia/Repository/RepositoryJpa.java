package com.smedia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smedia.Entity.Employee;

public interface RepositoryJpa extends JpaRepository<Employee,Long> { 

}
