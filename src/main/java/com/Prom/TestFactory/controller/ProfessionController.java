package com.Prom.TestFactory.controller;

import com.Prom.TestFactory.model.Profession;
import com.Prom.TestFactory.service.ProfessionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profession")
@AllArgsConstructor
public class ProfessionController {
    private ProfessionService professionService;

    @GetMapping
    public List<Profession> findAllProfession() {
        return professionService.findAllProfession();
    }

    @PostMapping
    public Profession saveProfession(@RequestBody Profession profession) {
        return professionService.saveProfession(profession);
    }

    @GetMapping("/{id}")
    public Optional<Profession> findById(@PathVariable Long id) {
        return professionService.findById(id);
    }

    @PutMapping("/{id}")
    public Profession updateProfession(@RequestBody Profession updProfession, @PathVariable Long id) {
        return professionService.findById(id).map(currentProfession -> {
            currentProfession.setTitle(updProfession.getTitle());
            currentProfession.setNote(updProfession.getNote());

            return professionService.saveProfession(currentProfession);
        }).orElseGet(() -> {
            updProfession.setId(id);
            return professionService.saveProfession(updProfession);
        });

    }
    @DeleteMapping("/{id}")
    public void removeProfession(@PathVariable Long id) {
        professionService.removeProfession(id);
    }
}
