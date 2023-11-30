package com.rpdbackend.controllers;

import com.rpdbackend.models.Agent;
import com.rpdbackend.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentRepository repository;

    @PostMapping("/register")
    Agent newAgent(@RequestBody Agent newAgent){
        return repository.save(newAgent);
    }

    @GetMapping("/list")
    List<Agent> getAllAgents(){
        return repository.findAll();
    }

    @GetMapping("/agent/key={id}")
    public Agent getAgentById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agente não encontrado com o ID: " + id));
    }

    @PutMapping("/update/agent/key={id}")
    Agent updateAgent(@RequestBody Agent newAgent, @PathVariable Long id){
        return repository.findById(id)
                .map(agent -> {
                    agent.setName(newAgent.getName());
                    agent.setAge(newAgent.getAge());
                    agent.setRole(newAgent.getRole());
                    agent.setAddress(newAgent.getAddress());
                    agent.setPhone(newAgent.getPhone());
                    return repository.save(agent);
                }).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Agente não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/agent/key={id}")
    String deleteAgent(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Agente não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Agente com o  id " +id+ " foi deletado com sucesso!";
    }


}
