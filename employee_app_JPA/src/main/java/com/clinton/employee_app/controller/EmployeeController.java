package com.clinton.employee_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinton.employee_app.model.Employee;
import com.clinton.employee_app.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/home")
	public String listEmployees(Model theModel) {
		theModel.addAttribute("employees", employeeService.findAll());

		return "home";
	}

	@GetMapping("/showForm")
	public String showForm(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employee", employee);

		return "form";
	}

	@PostMapping("/save")
	public String saveDetails(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		
		return "redirect:/employees/home";
	}
	
	@GetMapping("/showUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel) {
		Employee employee = employeeService.findByID(id);
		
		theModel.addAttribute("employee", employee);
		
		return "form";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("employeeId") int theId) {
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employees/home";
	}

}
