package com.github.caarlos0.model;

import com.github.caarlos0.listeners.CursoEntityListener;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author: Carlos A Becker
 */
@Entity
@EntityListeners({CursoEntityListener.class})
public class Curso extends BaseBean {

    private String descricao;

    private int cargaHoraria;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Aluno> alunos;

    public Curso(String descricao, int cargaHoraria, List<Aluno> alunos) {
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.alunos = alunos;
    }

    public Curso() {
    }

    public void adicionaAlunos(Aluno... alunos) {
        assert this.alunos != null : "lista alunos está null!";
        assert alunos != null : "lista alunos está null!";
        for(Aluno a : alunos) {
            this.alunos.add(a);
        }
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "descricao='" + descricao + '\'' +
                ", id=" + getId() +
                ", version = " + getVersion() +
                ", cargaHoraria = " + cargaHoraria +
                ", alunos = " + alunos +
                '}';
    }
}
