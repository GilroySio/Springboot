package org.example;

import java.util.List;

public interface EmployeeService {
    public abstract List<EmployeeDTO> getEmployees();
    public abstract EmployeeDTO getEmployeeById(int id);
    public void updateEmployee(int id, Employee tempEmployee);
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
    public void addRole(int employeeId, int roleId);
    public void deleteRole(int employeeId, int roleId);
    public void addTicket(int employeeId, int ticketId);
    public void deleteTicket(int employeeId, int ticketId);
}
