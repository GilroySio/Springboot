package org.example;

import java.util.List;

public interface RoleService {
    public List<RoleDTO> getRoles();
    public RoleDTO getRoleById(int id);
    public void updateRole(int id, Role tempRole);
    public void addRole(Role role);
    public void deleteRole(int id);
}
