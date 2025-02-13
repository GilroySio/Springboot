package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

	EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String index() {
		return "spring boot";
	}

	@GetMapping("/employees")
	public List<Employee> employees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public Employee employeeById(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/employees/{id}")
	//public void updateEmployee(@PathVariable("id") int id, @RequestParam(required = false) String name, @RequestParam(required = false) int age, @RequestParam(required = false) String address, @RequestParam(required = false) String contactNo, @RequestParam(required = false) String employmentStatus) {
	public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		//employeeService.updateEmployee(id, name, age, address, contactNo, employmentStatus);
	}

	@PostMapping("/add-employee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping("/set-role/{employeeId}/{roleId}")
	public void setRole(@PathVariable("employeeId") int employeeId, @PathVariable("roleId") int roleId) {
		employeeService.setRole(employeeId, roleId);
	}
}
