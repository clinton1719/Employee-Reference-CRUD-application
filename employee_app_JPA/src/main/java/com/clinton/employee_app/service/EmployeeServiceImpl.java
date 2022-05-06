package com.clinton.employee_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinton.employee_app.dao.EmployeeRepository;
import com.clinton.employee_app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	public Employee findByID(int id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee employee = null;

		if (result.isPresent()) {
			employee = result.get();
		}

		return employee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

}
