package com.github.caarlos0.model;

import com.github.caarlos0.interfaces.Bean;

import javax.persistence.Entity;
import java.util.List;

/**
 * @author: Carlos A Becker
 */
@Entity
public class Aluno extends  BaseBean{
    private String nome;
    private int idade;

    public Aluno() {
    }

    public Aluno(Long id, Long version, String nome, int idade) {
        super(id, version);
        this.nome = nome;
        this.idade= idade;
    }

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id = " + getId() +
                ", version " + getVersion() +
                ", nome = '" + nome + '\'' +
                ", idade = " + idade +
                '}';
    }
}
