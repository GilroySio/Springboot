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
public class Role {
    @Id
    @SequenceGenerator(name = "roleSequence", sequenceName = "roleSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequence")
    private int id;
    private String title;
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<Employee> employees = new ArrayList<Employee>();

    public Role(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
