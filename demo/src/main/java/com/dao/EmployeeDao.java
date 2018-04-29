package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Employee;
//@Component
//@Repository("Employee")
//@RestResource(path="employees", rel="employees")
//@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{

	List<Employee> findAll();
	
	Optional<Employee> getEmployeeById(Long empId);
	
	Optional<Employee> getEmployeeByempId(String empId);
	
	@Override
	void delete(Employee entity);
	 
	@Override
	Employee save(Employee entity);

}