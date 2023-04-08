package com.josevabo.infnetdevops.medico.repository;

import com.josevabo.infnetdevops.medico.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    public Medico findByCodigo(Long codigo);
}
