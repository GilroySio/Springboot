package org.example;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Ticket {
    @Id
    @SequenceGenerator(name = "ticketSequence", sequenceName = "ticketSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketSequence")
    private int id;
    private String title;
    private String body;
    @ManyToMany
    @JoinTable(name = "ticket_employee", joinColumns = @JoinColumn(name = "ticket_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> assignees = new ArrayList<>();
    private String status;
    private LocalDate createdDate;
    @ManyToOne
    @JoinTable(
            name = "ticket_create_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private Employee createdBy;
    private LocalDate updatedDate;
    @ManyToOne
    @JoinTable(
            name = "ticket_update_employee",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private Employee updatedBy;
    private String remarks;
}
