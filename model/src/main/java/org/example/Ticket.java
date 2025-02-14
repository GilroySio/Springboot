package org.example;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Entity
//@Table
public class Ticket {
    //@Id
    //@SequenceGenerator(name = "ticketSequence", sequenceName = "ticketSequence", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketSequence")
    private int id;
    private String title;
    private String body;
    //@ManyToMany(mappedBy = "tickets")
    private List<Employee> assignees;
    private String status;
    private String createdDate;
    private Employee createdBy;
    private String updatedDate;
    private Employee updatedBy;
    private String remarks;
}
