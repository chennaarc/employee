package com.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@XmlRootElement
@Entity
public class Employee {
	
	@Id @GeneratedValue
	Long id;
	String empId;
	String firstName;
	String lastName;
	int age;
	
	public Employee() {
		super();
	}
	
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		 return(" this.empId => "+this.empId+"  this.firstName => "+this.firstName + " this.lastName => "+this.lastName + " this.age =>"+ this.age );
	}
}