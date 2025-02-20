package org.example.impl;

import jakarta.transaction.Transactional;
import org.example.Role;
import org.example.RoleDTO;
import org.example.RoleRepo;
import org.example.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    public List<RoleDTO> getRoles() {
        return roleRepo.findAll().stream().map(RoleDTO::new).toList();
    }

    public RoleDTO getRoleById(int id) {
        Role role = roleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("role with id " + id + " does not exist"));
        return new RoleDTO(role);
    }

    @Transactional
    public RoleDTO updateRole(int id, Role tempRole) {
        Role r = roleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("role with id " + id + " does not exist"));
        if(tempRole == null) {
            throw new IllegalArgumentException("null input");
        }
        if(tempRole.getTitle() != null && !tempRole.getTitle().isEmpty()) {
            r.setTitle(tempRole.getTitle());
        }
        if(tempRole.getDescription() != null && !tempRole.getDescription().isEmpty()) {
            r.setDescription(tempRole.getDescription());
        }
        return new RoleDTO(r);
    }

    @Transactional
    public RoleDTO addRole(Role role) {
        if(role.getTitle() == null || role.getTitle().isEmpty()) {
            throw new IllegalArgumentException("cannot add role without title");
        }
        if(role.getDescription() == null || role.getDescription().isEmpty()) {
            throw new IllegalArgumentException("cannot add role without description");
        }
        roleRepo.save(role);
        return new RoleDTO(role);
    }

    public void deleteRole(int id) {
        if(!roleRepo.existsById(id)) {
            throw new IllegalArgumentException("role with id " + id + " does not exist");
        }
        roleRepo.deleteById(id);
    }
}
