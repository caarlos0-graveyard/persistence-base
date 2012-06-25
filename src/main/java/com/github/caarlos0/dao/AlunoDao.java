package com.github.caarlos0.dao;

import com.github.caarlos0.model.Aluno;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author: Carlos A Becker
 */
public class AlunoDao extends AbstractDao<Aluno> {
    @Inject
    public AlunoDao(Provider<EntityManager> emf) {
        super(emf, Aluno.class);
    }

    /**
     * Busca todos os alunos em um intervalo de idade.
     * @param idadeMin
     * @param idadeMax
     * @return
     */
    @Transactional
    public List<Aluno> findAllByIdade(int idadeMin, int idadeMax) {
        TypedQuery<Aluno> q = em().createQuery("SELECT e FROM Aluno e WHERE e.idade BETWEEN :min and :max", Aluno.class);
        return q.setParameter("min", idadeMin).setParameter("max", idadeMax).getResultList();
    }

}
