package org.example;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployees();
    EmployeeDTO getEmployeeById(int id);
    void updateEmployee(int id, Employee tempEmployee);
    void addEmployee(Employee employee);
    void deleteEmployee(int id);
    void addRole(int employeeId, int roleId);
    void deleteRole(int employeeId, int roleId);
    void addTicket(int employeeId, int ticketId);
    void deleteTicket(int employeeId, int ticketId);
}
