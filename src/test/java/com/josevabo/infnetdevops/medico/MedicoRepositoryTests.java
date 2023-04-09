package com.josevabo.infnetdevops.medico;

import com.josevabo.infnetdevops.medico.model.Medico;
import com.josevabo.infnetdevops.medico.repository.MedicoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicoRepositoryTests {

    @Autowired
    private MedicoRepository medicoRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    void saveMedicoTest() {
        Medico medico = new Medico();
        medico.setNome("Joao");
        medico.setCrm("DF1234");
        medico.setCpf("9999999999");
        medico.setDataNascimento(LocalDate.of(1999, 1, 1));

        medicoRepository.save(medico);

        Assertions.assertThat(medico.getCodigo()).isPositive();
    }

    @Test
    @Order(2)
    void getMedicoTest() {
        Medico medico = medicoRepository.findById(1L).get();

        Assertions.assertThat(medico.getCodigo()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    void getListOfMedicosTest() {
        List<Medico> medicos = medicoRepository.findAll();

        Assertions.assertThat(medicos).isNotEmpty();
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    void updateMedicoTest() {
        Medico medico = medicoRepository.findById(1L).get();
        final String NOVO_CRM = "SP45678";
        medico.setCrm(NOVO_CRM);
        Medico medicoUpdated = medicoRepository.save(medico);

        Assertions.assertThat(medicoUpdated.getCrm()).isEqualTo(NOVO_CRM);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    void deleteMedicoTest() {
        Medico medico = medicoRepository.findById(1L).get();
        medicoRepository.delete(medico);
        Medico medico1 = medicoRepository.findByCodigo(1L);

        Assertions.assertThat(medico1).isNull();
    }
}