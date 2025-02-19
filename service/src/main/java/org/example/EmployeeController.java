package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;

	@GetMapping("/")
	public String index() {
		return "spring boot";
	}

	@GetMapping("/employees")
	public List<EmployeeDTO> employees() {
		return employeeServiceImpl.getEmployees();
	}

	@GetMapping("/employees/{id}")
	public EmployeeDTO employeeById(@PathVariable("id") int id) {
		return employeeServiceImpl.getEmployeeById(id);
	}

	@PutMapping("/employees/{id}")
	public void updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		employeeServiceImpl.updateEmployee(id, employee);
		//employeeService.updateEmployee(id, name, age, address, contactNo, employmentStatus);
	}

	@PostMapping("/add-employee")
	public void addEmployee(@RequestBody Employee employee) {
		employeeServiceImpl.addEmployee(employee);
	}

	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeServiceImpl.deleteEmployee(id);
	}

	@PutMapping("/add-role/{employeeId}/role/{roleId}")
	public void setRole(@PathVariable("employeeId") int employeeId, @PathVariable("roleId") int roleId) {
		employeeServiceImpl.addRole(employeeId, roleId);
	}

	@PutMapping("/delete-role/{employeeId}/role/{roleId}")
	public void deleteRole(@PathVariable("employeeId") int employeeId, @PathVariable("roleId") int roleId) {
		employeeServiceImpl.deleteRole(employeeId, roleId);
	}

	@PutMapping("/add-ticket/{employeeId}/ticket/{ticketId}")
	public void setTicket(@PathVariable("employeeId") int employeeId, @PathVariable("ticketId") int ticketId) {
		employeeServiceImpl.addTicket(employeeId, ticketId);
	}

	@PutMapping("/delete-ticket/{employeeId}/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("employeeId") int employeeId, @PathVariable("ticketId") int ticketId) {
		employeeServiceImpl.deleteTicket(employeeId, ticketId);
	}
}
