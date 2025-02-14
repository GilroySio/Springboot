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
    private List<RoleDTO> roles = new ArrayList<RoleDTO>();

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
        this.age = e.getAge();
        this.address = e.getAddress();
        this.contactNo = e.getContactNo();
        this.employmentStatus = e.getEmploymentStatus();
        for(Role role: e.getRoles()) {
            this.roles.add(new RoleDTO(role));
        }
    }
}
