package org.example;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, RoleRepo roleRepo) {
        this.employeeRepo = employeeRepo;
        this.roleRepo = roleRepo;
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("employee with id" + id + "does not exist"));
    }

    @Transactional
    public void updateEmployee(int id, Employee tempEmployee) {
        Employee e = employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("employee with id" + id + "does not exist"));
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
        System.out.println(tempEmployee);
    }

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    public void deleteEmployee(int id) {
        if(!employeeRepo.existsById(id)) {
            throw new IllegalArgumentException("employee with id" + id + "does not exist");
        }
        employeeRepo.deleteById(id);
    }

    @Transactional
    public void setRole(int employeeId, int roleId) {
        Employee e = employeeRepo.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("employee with id" + employeeId + "does not exist"));
        Role r = roleRepo.findById(roleId).orElseThrow(() -> new IllegalArgumentException("employee with id" + roleId + "does not exist"));
        e.setRole(r);
    }
}
