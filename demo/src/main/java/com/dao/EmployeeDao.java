package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{

	List<Employee> findAll();
	
	Optional<Employee> getEmployeeById(Long empId);
	
	Optional<Employee> getEmployeeByempId(String empId);
	
	@Override
	@Transactional
	void delete(Employee entity);
	 
	@Override
	@Transactional
	Employee save(Employee entity);

}
