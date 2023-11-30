package com.rpdbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.rpdbackend.models.BiologicalWeapon;
import com.rpdbackend.repositories.BiologicalWeaponRepository;

@RestController
@RequestMapping("/biologicalWeapons")
public class BiologicalWeaponController {
    
    @Autowired
    private BiologicalWeaponRepository repository;

    @PostMapping("/register")
    BiologicalWeapon newBioWeapon(@RequestBody BiologicalWeapon newBioWeapon){
        return repository.save(newBioWeapon);
    }

    @GetMapping("/list")
    List<BiologicalWeapon> getAllBioWeapons(){
        return repository.findAll();
    }

    @GetMapping("/bioWeapon/key={id}")
    public BiologicalWeapon getBioWeaponById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Arma Biologica não encontrado com o ID: " + id));
    }

    @PutMapping("/update/bioWeapon/key={id}")
    BiologicalWeapon updateBioWeapon(@RequestBody BiologicalWeapon newBioWeapon, @PathVariable Long id){
        return repository.findById(id)
                .map(bioWeapon -> {
                    bioWeapon.setName(newBioWeapon.getName());
                    bioWeapon.setWeight(newBioWeapon.getWeight());
                    bioWeapon.setHeight(newBioWeapon.getHeight());
                    bioWeapon.setContained(newBioWeapon.getContained());
                    bioWeapon.setBioWeaponType(newBioWeapon.getBioWeaponType());
                    return repository.save(bioWeapon);
                }).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Arma Biologica não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/bioWeapon/key={id}")
    String deleteBioWeapon(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Arma Biologica não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Arma Biologica com o  id " +id+ " foi deletado com sucesso!";
    }
}
