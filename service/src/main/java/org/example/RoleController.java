package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<RoleDTO> getRoles() {
        return roleService.getRoles();
    }

    @GetMapping("/roles/{id}")
    public RoleDTO employeeById(@PathVariable("id") int id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("/roles/{id}")
    public void updateEmployee(@PathVariable("id") int id, @RequestBody Role role) {
        roleService.updateRole(id, role);
    }

    @PostMapping("/add-role")
    public void addEmployee(@RequestBody Role role) {
        roleService.addRole(role);
    }

    @DeleteMapping("/delete-role/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        roleService.deleteRole(id);
    }
}
