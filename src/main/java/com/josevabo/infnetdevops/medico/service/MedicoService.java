package com.josevabo.infnetdevops.medico.service;

import com.josevabo.infnetdevops.medico.model.Medico;
import com.josevabo.infnetdevops.medico.repository.MedicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    Logger logger = LoggerFactory.getLogger(MedicoService.class);

    @Autowired
    MedicoRepository repository;

    public List<Medico> listAll() {
        logger.info("Listando todos medicos");
        return repository.findAll();
    }

    public Medico findByCodigo(Long codigo) {
        logger.info("Buscando paciente por codigo: {}", codigo);
        Medico medico = repository.findByCodigo(codigo);
        if (medico == null) return null;
        return medico;
    }

    public Medico create(Medico entidade) {
        logger.info("Criando medico de nome: {}", entidade.getNome());
        if(entidade.getCodigo() != null) entidade.setCodigo(null);
        return repository.save(entidade);
    }

    public Medico update(Medico entidade) {
        logger.info("Atualizando medico de nome: {}", entidade.getNome());
        if(entidade.getCodigo() == null) throw new IllegalArgumentException("Código do médico não informado");
        return repository.save(entidade);
    }

    public Medico delete(Long codigo) {
        logger.info("Deletando medico de codigo: {}", codigo);
        Medico deletado = repository.findByCodigo(codigo);
        repository.deleteById(codigo);
        return deletado;
    }
}
