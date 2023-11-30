package com.rpdbackend.controllers;

import com.rpdbackend.models.Phone;
import com.rpdbackend.models.Role;
import com.rpdbackend.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private PhoneRepository repository;

    @PostMapping("/register")
    Phone newPhone(@RequestBody Phone newPhone){
        return repository.save(newPhone);
    }

    @GetMapping("/list")
    List<Phone> getAllPhones(){
        return repository.findAll();
    }

    @GetMapping("/phone/key={id}")
    public Phone getPhoneById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Telefone não encontrado com o ID: " + id));
    }

    @PutMapping("/update/phone/key={id}")
    Phone updatePhone(@RequestBody Phone newPhone, @PathVariable Long id){
        return repository.findById(id)
                .map(phone -> {
                    phone.setNumber(newPhone.getNumber());
                    return repository.save(phone);
                }).orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Telefone não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/phone/key={id}")
    String deletePhone(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Telefone não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Telefone com o  id " +id+ " foi deletado com sucesso!";
    }
}
