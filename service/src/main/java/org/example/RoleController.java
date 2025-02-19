package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    RoleServiceImpl roleServiceImpl;
    
    @GetMapping("/roles")
    public List<RoleDTO> getRoles() {
        return roleServiceImpl.getRoles();
    }

    @GetMapping("/roles/{id}")
    public RoleDTO getRoleById(@PathVariable("id") int id) {
        return roleServiceImpl.getRoleById(id);
    }

    @PutMapping("/roles/{id}")
    public void updateRole(@PathVariable("id") int id, @RequestBody Role role) {
        roleServiceImpl.updateRole(id, role);
    }

    @PostMapping("/add-role")
    public void addRole(@RequestBody Role role) {
        roleServiceImpl.addRole(role);
    }

    @DeleteMapping("/delete-role/{id}")
    public void deleteRole(@PathVariable("id") int id) {
        roleServiceImpl.deleteRole(id);
    }
}
