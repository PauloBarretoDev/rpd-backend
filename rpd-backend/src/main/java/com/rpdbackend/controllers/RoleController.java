package com.rpdbackend.controllers;

import com.rpdbackend.models.Role;
import com.rpdbackend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @PostMapping("/register")
    Role newRole(@RequestBody Role newRole){
        return repository.save(newRole);
    }

    @GetMapping("/list")
    List<Role> getAllRoles(){
        return repository.findAll();
    }

    @GetMapping("/role/key={id}")
    public Role getRoleById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cargo não encontrado com o ID: " + id));
    }

    @PutMapping("/update/role/key={id}")
    Role updateRole(@RequestBody Role newRole, @PathVariable Long id){
        return repository.findById(id)
                .map(role -> {
                    role.setName(newRole.getName());
                    return repository.save(role);
                }).orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cargo não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/role/key={id}")
    String deleteRole(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Cargo não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Cargo com o  id " +id+ " foi deletado com sucesso!";
    }

}
