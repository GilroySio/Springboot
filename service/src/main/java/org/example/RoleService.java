package org.example;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getRoles();
    RoleDTO getRoleById(int id);
    RoleDTO updateRole(int id, Role tempRole);
    RoleDTO addRole(Role role);
    void deleteRole(int id);
}
