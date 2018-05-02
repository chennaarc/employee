package com.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Employee;
import com.util.Sanitization;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private static Logger logger = LogManager.getLogger(EmployeeController.class);
	
	@Autowired(required = true)
	com.dao.EmployeeDao empDao;	
	
	@RequestMapping("/getAll")
	public List<Employee> getAll() {
		logger.info("#### all ####");
		return empDao.findAll();
	}
	
	@RequestMapping("/getemployeebyid/{empId}")
	public Optional<Employee> getEmployeeById(@PathVariable("empId") Long empId) {
		logger.info("#### empId => "+empId);
		return empDao.getEmployeeById(empId);
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, value="/insertemployee")
	public ResponseEntity<Object> insertEmployee(@RequestBody Employee emp) {
		logger.info("#### empId =>"+emp);
		
		Sanitization.processSantizeData(emp);
		
		Optional<Employee> empOptional = empDao.getEmployeeByempId(emp.getEmpId());

		if (!empOptional.isPresent()) {
			Employee savedEmp = empDao.save(emp);
			logger.info("#### empIdnot found #### ");
			return ResponseEntity.ok().body(savedEmp);
		}
		return ResponseEntity.ok().body("Employee exists" );
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, value="/updateemployee")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp) {
		logger.info("####  empId =>"+emp);
		
		Sanitization.processSantizeData(emp);

		Optional<Employee> empOptional = empDao.getEmployeeById(emp.getId());

		if (empOptional.isPresent()) {
			Employee savedEmp = empDao.save(emp);
			logger.info(" ### empId found and updating #### ");
			return ResponseEntity.ok().body(savedEmp);
		}
		return ResponseEntity.ok().body("Employee object has not updated " );
	}	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteemployee/{empId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("empId") Long empId) {
			logger.info("### empId => "+empId);
			Optional<Employee> empOptional = empDao.getEmployeeById(empId);
	
			if (empOptional.isPresent() ) {
				empDao.deleteById(empId);
				logger.info("#### /empId found and updating #### ");
				return ResponseEntity.ok().body("Employee sucessfully deleted");
			}
		
		return ResponseEntity.ok().body("problem in deleting Employee !");

	}
	


}
