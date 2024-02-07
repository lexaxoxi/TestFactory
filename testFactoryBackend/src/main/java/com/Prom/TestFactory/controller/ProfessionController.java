package com.Prom.TestFactory.controller;

import com.Prom.TestFactory.model.Profession;
import com.Prom.TestFactory.service.ProfissionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profession")
@AllArgsConstructor
public class ProfessionController {
    private ProfissionService profissionService;

    @GetMapping
    public List<Profession> findAllProfession() {
        return profissionService.findAllProfession();
    }

    @PostMapping("save_profession")
    public Profession saveProfession(@RequestBody Profession profession) {
        return profissionService.saveProfession(profession);
    }

    @GetMapping("/{id}")
    public Optional<Profession> findById(@PathVariable Long id) {
        return profissionService.findById(id);
    }

    @PutMapping("update_profession/{id}")
    public Profession updateProfession(@RequestBody Profession updProfession, @PathVariable Long id) {
        return profissionService.findById(id).map(currentProfession -> {
            currentProfession.setTitle(updProfession.getTitle());
            currentProfession.setNote(updProfession.getNote());

            return profissionService.saveProfession(currentProfession);
        }).orElseGet(() -> {
            updProfession.setId(id);
            return profissionService.saveProfession(updProfession);
        });

    }
    @DeleteMapping("remove_profession/{id}")
    public void removeProfession(@PathVariable Long id) {
        profissionService.removeProfession(id);
    }
}
