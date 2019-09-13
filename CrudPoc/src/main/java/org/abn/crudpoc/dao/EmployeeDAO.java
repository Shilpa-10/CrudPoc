package org.abn.crudpoc.dao;

import java.util.List;

import org.abn.crudpoc.model.Employee;
import org.abn.crudpoc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository ;
	
	//to save an Employee
	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
		
	}
	//to search all employees
	public List <Employee> findAll(){
		return employeeRepository.findAll();
		
	}
	
	//update or get an employee by ID
	public Employee findOne(Long empid) {
		return employeeRepository.findById(empid).orElse(null);
	}
	
	//delete an employee  
	public void delete(Employee emp ) {
		  employeeRepository.delete(emp);
	}
	
	
}
