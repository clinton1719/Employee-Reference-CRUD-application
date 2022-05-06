package com.clinton.employee_app.service;


import java.util.List;

import com.clinton.employee_app.model.Employee;


public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findByID(int id);

	public void saveEmployee(Employee theEmployee);

	public void deleteEmployee(int id);

}
