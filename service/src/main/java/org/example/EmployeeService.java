package org.example;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeById(int id);
    EmployeeDTO updateEmployee(int id, Employee tempEmployee);
    EmployeeDTO addEmployee(Employee employee);
    void deleteEmployee(int id);
    EmployeeDTO addRole(int employeeId, int roleId);
    EmployeeDTO deleteRole(int employeeId, int roleId);
    EmployeeDTO addTicket(int employeeId, int ticketId);
    EmployeeDTO deleteTicket(int employeeId, int ticketId);
}
