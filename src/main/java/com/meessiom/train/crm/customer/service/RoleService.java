package com.meessiom.train.crm.customer.service;

import com.meessiom.train.crm.common.exception.ResourceNotFoundException;
import com.meessiom.train.crm.customer.model.Customer;
import com.meessiom.train.crm.customer.model.Role;
import com.meessiom.train.crm.customer.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role createRole(Role role){

        return roleRepository.save(role);
    }

    public String getRoleNameByRoleId(long id){
        String roleName = roleRepository.getRoleNameByRoleId(id);
        return roleName;
    }

    public Role getRoleById(long id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not exist with id" + id));
        return role;
    }

    public Role updateRole(long id, Role RoleDetails){
        Role updateRole = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not exist with id" + id));
        updateRole.setRoleName(RoleDetails.getRoleName());
        updateRole.setRoleStatus(RoleDetails.getRoleStatus());
        roleRepository.save(updateRole);
        return updateRole;
    }

    public void deleteRole(long id){
        Role role = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not exist with id" + id));

        roleRepository.delete(role);
    }
}
