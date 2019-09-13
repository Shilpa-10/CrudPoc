package org.abn.crudpoc.controller;

import java.util.List;

import javax.validation.Valid;

import org.abn.crudpoc.dao.EmployeeDAO;
import org.abn.crudpoc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	// to save an employee

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}

	// get all employee
	@GetMapping("/employees")

	public List<Employee> getAllEmployees() {
		return employeeDAO.findAll();

	}

	// get employee by particular id

	@GetMapping("/notes/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empId) {
		Employee emp = employeeDAO.findOne(empId);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(emp);
		}
	}

	// update an employee by empId

	@PutMapping("/employees/{id}")

	public ResponseEntity<Employee> updateEmployeeById(@PathVariable(value = "id") Long empId,
			@Valid @RequestBody Employee empDetails) {
		Employee emp = employeeDAO.findOne(empId);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		// emp.setId(empDetails.getId());
		emp.setName(empDetails.getName1());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());

		Employee updatedEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(empDetails);
	}
	
	//Delete an employee
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable(value="id") Long empId){
		Employee emp = employeeDAO.findOne(empId);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	

 
}
