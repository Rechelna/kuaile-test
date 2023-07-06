package com.meessiom.train.crm.customer.controller;

import com.meessiom.train.crm.customer.model.Customer;
import com.meessiom.train.crm.customer.model.Role;
import com.meessiom.train.crm.customer.repository.CustomerRepository;
import com.meessiom.train.crm.customer.repository.RoleRepository;
import com.meessiom.train.crm.customer.service.CustomerService;
import com.meessiom.train.crm.customer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;


    // Build get customers REST API
    @GetMapping
    public List<Role> getAllRole(){
        return roleService.getAllRoles();
    }

    // Build create customer REST API
    @PostMapping
    public Role createRole( Role role){
        return roleService.createRole(role);
    }

    // Build get customer by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable long id){
        Role role = roleService.getRoleById(id);
        return ResponseEntity.ok(role);
    }

    @GetMapping("/getRoleNameById/{id}")
    public String getRoleNameByRoleId( @PathVariable long id){
        String roleName = roleService.getRoleNameByRoleId(id);
        return roleName;
    }
    // Build update customer REST API
    @PutMapping("{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable long id,@RequestBody Role roleDetails){
        Role updateRole = roleService.updateRole(id,roleDetails);

        return ResponseEntity.ok(updateRole);
    }

    // Build delete customer REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable long id){
        roleService.deleteRole(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
