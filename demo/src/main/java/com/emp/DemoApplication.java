package com.emp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.domain.Employee;

@SpringBootApplication
//@ComponentScan(basePackages ={"com.controller", "com.dao.*", "com.dao.EmployeeDao"})
@ComponentScan(basePackages ={"com.controller"})
@EnableJpaRepositories(basePackages="com.dao")
@EnableTransactionManagement
@EnableAutoConfiguration
@EntityScan(basePackages="com.domain")
public class DemoApplication extends SpringBootServletInitializer{
	
	@Autowired
	com.dao.EmployeeDao empDao;	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}		
	
	@PostConstruct
	public void init() {
		Employee emp = new Employee();
		emp.setEmpId("1");
		emp.setFirstName("Steve");
		emp.setLastName("Smith");
		emp.setAge(22);
		empDao.save(emp);
		
		emp = new Employee();
		emp.setEmpId("2");
		emp.setFirstName("Mike");
		emp.setLastName("John");
		emp.setAge(25);
		empDao.save(emp);
	}	
}
