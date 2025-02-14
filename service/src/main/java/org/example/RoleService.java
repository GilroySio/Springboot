package org.example;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<RoleDTO> getRoles() {
        List<Role> roleList = roleRepo.findAll();
        List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
        for(Role r: roleList) {
            roleDTOList.add((new RoleDTO(r)));
        }
        return roleDTOList;
    }

    public RoleDTO getRoleById(int id) {
        Role role = roleRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("role with id " + id + " does not exist"));
        return new RoleDTO(role);
    }

    @Transactional
    public void updateRole(int id, Role tempRole) {
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
        System.out.println(tempRole);
    }

    public void addRole(Role role) {
        roleRepo.save(role);
    }

    public void deleteRole(int id) {
        if(!roleRepo.existsById(id)) {
            throw new IllegalArgumentException("role with id " + id + " does not exist");
        }
        roleRepo.deleteById(id);
    }
}
