package com.Prom.TestFactory.repo;

import com.Prom.TestFactory.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
    void removeById(Long id);

    Optional<Profession> findById(Long id);

}
