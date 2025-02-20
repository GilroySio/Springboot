package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String index() {
		return "spring boot";
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> employees() {
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> employeeById(@PathVariable("id") int id) {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.updateEmployee(id, employee), HttpStatus.OK);
	}

	@PostMapping("/add-employee")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
	}

	@PutMapping("/add-role/{employeeId}/role/{roleId}")
	public ResponseEntity<EmployeeDTO> setRole(@PathVariable("employeeId") int employeeId, @PathVariable("roleId") int roleId) {
		return new ResponseEntity<>(employeeService.addRole(employeeId, roleId), HttpStatus.OK);
	}

	@PutMapping("/delete-role/{employeeId}/role/{roleId}")
	public ResponseEntity<EmployeeDTO> deleteRole(@PathVariable("employeeId") int employeeId, @PathVariable("roleId") int roleId) {
		return new ResponseEntity<>(employeeService.deleteRole(employeeId, roleId), HttpStatus.OK);
	}

	@PutMapping("/add-ticket/{employeeId}/ticket/{ticketId}")
	public ResponseEntity<EmployeeDTO> setTicket(@PathVariable("employeeId") int employeeId, @PathVariable("ticketId") int ticketId) {
		return new ResponseEntity<>(employeeService.addTicket(employeeId, ticketId), HttpStatus.OK);
	}

	@PutMapping("/delete-ticket/{employeeId}/ticket/{ticketId}")
	public ResponseEntity<EmployeeDTO> deleteTicket(@PathVariable("employeeId") int employeeId, @PathVariable("ticketId") int ticketId) {
		return new ResponseEntity<>(employeeService.deleteTicket(employeeId, ticketId), HttpStatus.OK);
	}
}
