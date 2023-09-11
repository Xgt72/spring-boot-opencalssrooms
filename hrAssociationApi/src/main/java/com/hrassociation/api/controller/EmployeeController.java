package com.hrassociation.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrassociation.api.model.Employee;
import com.hrassociation.api.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Read - Get all employees
	 * 
	 * @return - An Iterable object of Employee full filled
	 */
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	/**
	 * Read - Get one employee
	 * 
	 * @param id The id of the employee
	 * @return - An Employee
	 */
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") final Long id) {
		Optional<Employee> employee = employeeService.getEmployee(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	/**
	 * Create - Add a new employee
	 * 
	 * @param employee An object employee
	 * @return The employee object saved
	 */
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	/**
	 * Update - Update an existing employee
	 * 
	 * @param id       - The id of the employee to update
	 * @param employee - The employee object updated
	 * @return
	 */
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") final Long id, @RequestBody Employee employee) {
		Optional<Employee> e = employeeService.getEmployee(id);
		if (e.isPresent()) {
			Employee currentEmployee = e.get();

			String firstName = employee.getFirstName();
			if (firstName != null) {
				currentEmployee.setFirstName(firstName);
			}

			String lastName = employee.getLastName();
			if (lastName != null) {
				currentEmployee.setLastName(lastName);
			}

			String mail = employee.getMail();
			if (mail != null) {
				currentEmployee.setMail(mail);
			}

			String password = employee.getPassword();
			if (password != null) {
				currentEmployee.setPassword(password);
			}
			employeeService.saveEmployee(currentEmployee);
			return currentEmployee;
		} else {
			return null;
		}
	}

	/**
	 * Delete - Delete an employee
	 * 
	 * @param id - The id of the employee to delete
	 */
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		employeeService.deleteEmployee(id);
	}
}
