package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
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
public class RoleDTO {
    private int id;
    private String title;
    private String description;
    private List<Integer> employees = new ArrayList<Integer>();

    public RoleDTO(Role r) {
        this.id = r.getId();
        this.title = r.getTitle();
        this.description = r.getDescription();
        this.employees = r.getEmployees().stream().map(Employee::getId).toList();
    }
}
