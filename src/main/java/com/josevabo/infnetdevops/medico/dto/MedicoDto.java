package com.josevabo.infnetdevops.medico.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.josevabo.infnetdevops.medico.model.Medico} entity
 */
public class MedicoDto implements Serializable {
    private Long codigo;
    private String cpf;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String nome;
    private String crm;

    public MedicoDto() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicoDto entity = (MedicoDto) o;
        return Objects.equals(this.codigo, entity.codigo) &&
                Objects.equals(this.cpf, entity.cpf) &&
                Objects.equals(this.dataNascimento, entity.dataNascimento) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.crm, entity.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, cpf, dataNascimento, nome, crm);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "codigo = " + codigo + ", " +
                "cpf = " + cpf + ", " +
                "dataNascimento = " + dataNascimento + ", " +
                "nome = " + nome + ", " +
                "crm = " + crm + ")";
    }
}