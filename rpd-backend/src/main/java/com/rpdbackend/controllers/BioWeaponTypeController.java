package com.rpdbackend.controllers;

import com.rpdbackend.models.BioWeaponType;
import com.rpdbackend.repositories.BioWeaponTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/bioWeaponTypes")
public class BioWeaponTypeController {

    @Autowired
    private BioWeaponTypeRepository repository;

    @PostMapping("/register")
    BioWeaponType newBioWeaponType(@RequestBody BioWeaponType newBioWeaponType){
        return repository.save(newBioWeaponType);
    }

    @GetMapping("/list")
    List<BioWeaponType> getAllBioWeaponTypes(){
        return repository.findAll();
    }

    @GetMapping("/bioWeaponType/key={id}")
    public BioWeaponType getBioWeaponById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tipo de arma biológica não encontrado com o ID: " + id));
    }

    @PutMapping("/update/bioWeaponType/key={id}")
    BioWeaponType updateBioWeaponType(@RequestBody BioWeaponType newBioWeaponType, @PathVariable Long id){
        return repository.findById(id)
                .map(bioWeaponType -> {
                    bioWeaponType.setName(newBioWeaponType.getName());
                    bioWeaponType.setDescription(newBioWeaponType.getDescription());
                    bioWeaponType.setWeakness(newBioWeaponType.getWeakness());
                    return repository.save(bioWeaponType);
                }).orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Tipo de arma biológica não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/bioWeaponType/key={id}")
    String deleteBioWeaponType(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Tipo de arma biológica não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Tipo de arma biológica com o  id " +id+ " foi deletado com sucesso!";
    }


}
