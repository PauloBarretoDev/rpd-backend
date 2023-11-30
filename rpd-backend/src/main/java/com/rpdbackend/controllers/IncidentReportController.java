package com.rpdbackend.controllers;

import com.rpdbackend.models.IncidentReport;
import com.rpdbackend.repositories.IncidentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@CrossOrigin
public class IncidentReportController {

    @Autowired
    private IncidentReportRepository repository;

    @PostMapping("/register")
    IncidentReport newIncidentReport(@RequestBody IncidentReport newIncidentReport){
        return repository.save(newIncidentReport);
    }

    @GetMapping("/list")
    List<IncidentReport> getAllIncidents(){
        return repository.findAll();
    }

    @GetMapping("/incident/key={id}")
    public IncidentReport getIncidentById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Boletim não encontrado com o ID: " + id));
    }

    @PutMapping("/update/incident/key={id}")
    IncidentReport updateIncident(@RequestBody IncidentReport newIncident, @PathVariable Long id){
        return repository.findById(id)
                .map(incident -> {
                    incident.setIncidentName(newIncident.getIncidentName());
                    incident.setDescription(newIncident.getDescription());
                    incident.setSolved(newIncident.isSolved());
                    return repository.save(incident);
                }).orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Boletim não encontrado com o ID: " + id));
    }

    @DeleteMapping("/delete/incident/key={id}")
    String deleteIncident(@PathVariable Long id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Boletim não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
        return "Boletim com o  id " +id+ " foi deletado com sucesso!";
    }
}
