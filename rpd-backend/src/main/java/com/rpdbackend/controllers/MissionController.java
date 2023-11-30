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
import com.rpdbackend.models.Mission;
import com.rpdbackend.repositories.MissionRepository;

@RestController
@RequestMapping("/missions")
public class MissionController {
    
    @Autowired
    private MissionRepository repository;

    @PostMapping("/register")
    Mission newMission(@RequestBody Mission newMission){
        return repository.save(newMission);
    }

    @GetMapping("/list")
    List<Mission> getAllMissions(){
        return repository.findAll();
    }

    @GetMapping("/mission/key={id}")
    public Mission getMissionById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Missão não encontrado com o ID: " + id));
    }

    @PutMapping("/update/mission/key={id}")
    Mission updateMission(@RequestBody Mission newMission, @PathVariable Long id){
        return repository.findById(id)
                .map(mission -> {
                    mission.setName(newMission.getName());
                    mission.setDescription(newMission.getDescription());
                    mission.setAgent(newMission.getAgent());
                    mission.setAcomplished(newMission.isAcomplished());
                    return repository.save(mission);
                }).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Missão não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/mission/key={id}")
    String deleteBioWeapon(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Missão não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Missão com o  id " +id+ " foi deletado com sucesso!";
    }
}
