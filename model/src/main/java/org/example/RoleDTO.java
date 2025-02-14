package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private int id;
    private String title;
    private String description;

    public RoleDTO(Role r) {
        this.id = r.getId();
        this.title = r.getTitle();
        this.description = r.getDescription();

    }
}
