package com.github.caarlos0.dao;

import com.github.caarlos0.model.Bean;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Create your specific DAO extending this class, override the constructor ths way:
 * 
 * <code>
 * public class CursoDao extends GenericDao<Foo> {
 *   @Inject
 *   public CursoDao(Provider<EntityManager> emf) {
 *       super(emf, Foo.class);
 *   }
 * }
 * </code>
 * 
 * In this case, <i>Foo</i> has to extend <code>Bean</code>.
 *
 * @author Carlos A Becker
 */
public abstract class GenericDao<T extends Bean> {
   

    @Inject
    private Provider<EntityManager> emp;

    protected EntityManager em() {
        return emp.get();
    }

    protected abstract Class<T> clazz();

    @Inject
    public GenericDao() {
    }

    @Transactional
    public void save(T t) {
        if(t.getId() != null) {
            t = em().merge(t);
        } else {
            em().persist(t);
        }
    }
    
    public List<T> findAll() {
        TypedQuery<T> q = em().createQuery("select e from " + clazz().getSimpleName() + " e", clazz());
        return q.getResultList();
    }
    
    public T find(Long id) {
        return em().getReference(clazz(), id);
    }
    
    @Transactional
    public void remove(T t) {
        em().remove(t);
    }
}
