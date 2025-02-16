package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private int id;
    private String name;
    private Integer age;
    private String address;
    private String contactNo;
    private String employmentStatus;
    private List<RoleDTO> roles;
    private List<TicketDTO> tickets;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.age = e.getAge();
        this.address = e.getAddress();
        this.contactNo = e.getContactNo();
        this.employmentStatus = e.getEmploymentStatus();
        this.roles = e.getRoles().stream().map(RoleDTO::new).toList();
        this.tickets = e.getTickets().stream().map(TicketDTO::new).toList();
    }
}
