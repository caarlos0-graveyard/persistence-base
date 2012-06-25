package com.github.caarlos0.dao;

import com.github.caarlos0.model.Aluno;
import com.github.caarlos0.model.Curso;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author: Carlos A Becker
 */
public class CursoDao extends AbstractDao<Curso> {
    @Inject
    public CursoDao(Provider<EntityManager> emf) {
        super(emf, Curso.class);
    }

    /**
     * Busca por todos os cursos no qual algum aluno tenha o nome passado por parametro
     * @param name
     * @return
     */
    @Transactional
    public List<Curso> findAllByAlunoName(String name) {
        TypedQuery<Curso> q = em().createQuery("SELECT e FROM Curso e JOIN e.alunos a WHERE a.nome LIKE :nome", Curso.class);
        q.setParameter("nome", "%"+name+"%");
        return q.getResultList();
    }

    /**
     * Busca todos os cursos nos quais a carga horaria fique entre os valores passados por parametro.
     * @param min
     * @param max
     * @return
     */
    @Transactional
    public List<Curso> findAllByCargaHorariaBetween(int min, int max) {
        TypedQuery<Curso> q = em().createQuery("SELECT e from Curso e WHERE e.cargaHoraria BETWEEN :min and :max", Curso.class);
        q.setParameter("min", min).setParameter("max", max);
        return q.getResultList();
    }

    /**
     * Busca todos os cursos pelo nome.
     * @param name
     * @return
     */
    @Transactional
    public List<Curso> findAllByName(String name) {
        TypedQuery<Curso> q = em().createQuery("SELECT e from Curso e WHERE e.descricao LIKE :nome", Curso.class);
        q.setParameter("nome", name);
        return q.getResultList();
    }

    @Transactional
    public List<Curso> findAllFriendsCourse(List<String> friends) {
        TypedQuery<Curso> q = em().createQuery("SELECT e FROM Curso e JOIN e.alunos a WHERE a.nome IN :friends", Curso.class);
        return q.setParameter("friends", friends).getResultList();
    }
}
