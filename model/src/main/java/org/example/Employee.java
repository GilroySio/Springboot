package org.example;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "userSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSequence")
    private int id;
    private String name;
    private Integer age;
    private String address;
    private String contactNo;
    private String employmentStatus;
    @ManyToMany
    @JoinTable(name = "employee_role", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<Role>();
    @ManyToMany(mappedBy = "assignees")
    private List<Ticket> tickets = new ArrayList<Ticket>();

    public Employee(String name, int age, String address, String contactNo, String employmentStatus) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contactNo = contactNo;
        this.employmentStatus = employmentStatus;
    }
}
