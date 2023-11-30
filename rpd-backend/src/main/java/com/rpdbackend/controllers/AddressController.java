package com.rpdbackend.controllers;

import com.rpdbackend.models.Address;
import com.rpdbackend.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    
    @Autowired
    private AddressRepository repository;

    @PostMapping("/register")
    Address newAddress(@RequestBody Address newAddress){
        return repository.save(newAddress);
    }

    @GetMapping("/list")
    List<Address> getAllAddress(){
        return repository.findAll();
    }

    @GetMapping("/address/key={id}")
    public Address getAdressById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Endereço não encontrado com o ID: " + id));
    }

    @PutMapping("/update/address/key={id}")
    Address updateAddress(@RequestBody Address newAddress, @PathVariable Long id){
        return repository.findById(id)
                .map(address -> {
                    address.setStreet(newAddress.getCity());
                    address.setCity(newAddress.getCity());
                    address.setNumber(newAddress.getNumber());            
                    return repository.save(address);
                }).orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Endereço não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/address/key={id}")
    String deleteAddress(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Endereço não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Endereço com o  id " +id+ " foi deletado com sucesso!";
}
}
