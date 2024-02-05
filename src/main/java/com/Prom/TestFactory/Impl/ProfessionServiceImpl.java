package com.Prom.TestFactory.Impl;

import com.Prom.TestFactory.model.Department;
import com.Prom.TestFactory.model.Profession;
import com.Prom.TestFactory.repo.DepartmentRepository;
import com.Prom.TestFactory.repo.ProfessionRepository;
import com.Prom.TestFactory.service.DepartmentService;
import com.Prom.TestFactory.service.ProfissionService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class ProfessionServiceImpl implements ProfissionService {
    private final ProfessionRepository professionRepository;


    @Override
    public List<Profession> findAllProfession() {
        return professionRepository.findAll();
    }

    @Override
    public Profession saveProfession (Profession profession) {
        return professionRepository.save(profession);
    }

    @Override
    public Optional<Profession> findById(Long id) {
        return professionRepository.findById(id);
    }

    @Override
    public Profession updateProfession(Profession updProfession, Long id) {
        return professionRepository.save(updProfession);
    }

    @Override
    @Transactional
    public void removeProfession(Long id) {
        professionRepository.removeById(id);

    }
}
