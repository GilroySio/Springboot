package org.example.impl;

import jakarta.transaction.Transactional;
import org.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    TicketRepo ticketRepo;

    public List<EmployeeDTO> getEmployees() {
        return employeeRepo.findAll().stream().map(EmployeeDTO::new).toList();
    }

    public EmployeeDTO getEmployeeById(int id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("employee with id " + id + " does not exist"));
        return new EmployeeDTO(employee);
    }

    @Transactional
    public EmployeeDTO updateEmployee(int id, Employee tempEmployee) {
        Employee e = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("employee with id " + id + " does not exist"));
        if(tempEmployee == null) {
            throw new IllegalArgumentException("null input");
        }
        if(tempEmployee.getName() != null && !tempEmployee.getName().isEmpty()) {
            e.setName(tempEmployee.getName());
        }
        if(tempEmployee.getAge() != null && tempEmployee.getAge() > 0) {
            e.setAge(tempEmployee.getAge());
        }
        if(tempEmployee.getAddress() != null && !tempEmployee.getAddress().isEmpty()) {
            e.setAddress(tempEmployee.getAddress());
        }
        if(tempEmployee.getContactNo() != null && !tempEmployee.getContactNo().isEmpty()) {
            e.setContactNo(tempEmployee.getContactNo());
        }
        if(tempEmployee.getEmploymentStatus() != null && !tempEmployee.getEmploymentStatus().isEmpty()) {
            e.setEmploymentStatus(tempEmployee.getEmploymentStatus());
        }
        return new EmployeeDTO(e);
    }

    @Transactional
    public EmployeeDTO addEmployee(Employee employee) {
        if(employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("cannot add employee without name");
        }
        if(employee.getAge() == null || employee.getAge() == 0) {
            throw new IllegalArgumentException("cannot add employee without age");
        }
        if(employee.getAddress() == null || employee.getAddress().isEmpty()) {
            throw new IllegalArgumentException("cannot add employee without address");
        }
        if(employee.getContactNo() == null || employee.getContactNo().isEmpty()) {
            throw new IllegalArgumentException("cannot add employee without contact no");
        }
        employeeRepo.save(employee);
        return new EmployeeDTO(employee);
    }

    public void deleteEmployee(int id) {
        if(!employeeRepo.existsById(id)) {
            throw new IllegalArgumentException("employee with id " + id + " does not exist");
        }
        employeeRepo.deleteById(id);
    }

    @Transactional
    public EmployeeDTO addRole(int employeeId, int roleId) {
        Employee e = employeeRepo.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("employee with id " + employeeId + " does not exist"));
        Role r = roleRepo.findById(roleId).orElseThrow(() -> new IllegalArgumentException("role with id " + roleId + " does not exist"));
        for(Role role: e.getRoles()) {
            if(role.getId() == roleId) {
                throw new IllegalArgumentException("employee with id " + employeeId + " already has that role");
            }
        }
        e.getRoles().add(r);
        return new EmployeeDTO(e);
    }

    @Transactional
    public EmployeeDTO deleteRole(int employeeId, int roleId) {
        Employee e = employeeRepo.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("employee with id " + employeeId + " does not exist"));
        Role r = roleRepo.findById(roleId).orElseThrow(() -> new IllegalArgumentException("role with id " + roleId + " does not exist"));
        for(int i = 0; i < e.getRoles().size(); i++) {
            if(e.getRoles().get(i).getId() == roleId) {
                e.getRoles().remove(i);
                return new EmployeeDTO(e);
            }
        }
        throw new IllegalArgumentException("employee with id " + employeeId + " does not have that role");
    }
    @Transactional
    public EmployeeDTO addTicket(int employeeId, int ticketId) {
        Employee e = employeeRepo.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("employee with id " + employeeId + " does not exist"));
        Ticket t = ticketRepo.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("ticket with id " + ticketId + " does not exist"));
        for(Ticket ticket: e.getTickets()) {
            if(ticket.getId() == ticketId) {
                throw new IllegalArgumentException("employee with id " + employeeId + " already has that ticket assigned");
            }
        }
        t.getAssignees().add(e);
        return new EmployeeDTO(e);
    }

    @Transactional
    public EmployeeDTO deleteTicket(int employeeId, int ticketId) {
        Employee e = employeeRepo.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("employee with id " + employeeId + " does not exist"));
        Ticket t = ticketRepo.findById(ticketId).orElseThrow(() -> new IllegalArgumentException("ticket with id " + ticketId + " does not exist"));
        for(int i = 0; i < e.getRoles().size(); i++) {
            if(t.getAssignees().get(i).getId() == employeeId) {
                t.getAssignees().remove(i);
                return new EmployeeDTO(e);
            }
        }
        throw new IllegalArgumentException("employee with id " + employeeId + " does not have that ticket");
    }
}
