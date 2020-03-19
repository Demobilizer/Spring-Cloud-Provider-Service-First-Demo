/**
 * 
 */
package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;


/**
 * @author Mehul
**/

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/testNow")
	public String testingController() {
		return "coming to controller!";
	}

	@GetMapping("/viewEmployees")
	public List<Employee> getEmployees() {
		List<Employee> empList = employeeService.getEmployees();
		return empList;
	}
	
	@PostMapping("/save")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "";
	}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		employeeService.deleteEmployee(empId);
		return "success";
	}
	
	@GetMapping("/findEmp/{empId}")
	public Optional<Employee> findEmployeeById(@RequestBody int empId) {
		return employeeService.findEmployeeById(empId);
	}
	
	@PutMapping("/updateEmployee")
	public List<Employee> updateEmployee(@RequestBody Employee employee) {
		System.out.println("emp details---"+employee.toString());
		employeeService.addEmployee(employee);
		return employeeService.getEmployees();
	}
}
