package com.Prom.TestFactory.service;

import com.Prom.TestFactory.model.Profession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfissionService {
    public List<Profession> findAllProfession();
    Profession saveProfession(Profession profession);
    Optional<Profession> findById(Long id);
    Profession updateProfession(Profession updProfession, Long id);
    void removeProfession(Long id);
}
