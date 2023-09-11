package com.hrassociation.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrassociation.webapp.model.Employee;
import com.hrassociation.webapp.repository.EmployeeProxy;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeProxy employeeProxy;

  public Employee getEmployee(final Long id) {
    return employeeProxy.getEmployee(id);
  }

  public void deleteEmployee(final Long id) {
    employeeProxy.deleteEmployee(id);
  }

  public Iterable<Employee> getEmployees() {
    return employeeProxy.getEmployees();
  }

  public Employee saveEmployee(Employee employee) {
    Employee savedEmployee;

    employee.setLastName(employee.getLastName().toUpperCase());

    if (employee.getId() == null) {
      savedEmployee = employeeProxy.createEmployee(employee);
    } else {
      savedEmployee = employeeProxy.updateEmployee(employee);
    }
    return savedEmployee;
  }
}
