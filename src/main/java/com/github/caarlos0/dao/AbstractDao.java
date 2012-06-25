package com.github.caarlos0.dao;

import com.github.caarlos0.interfaces.Bean;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author carlos
 */
public abstract class AbstractDao<T extends Bean> {
   
    
    private Provider<EntityManager> emp;
    private final Class<T> clazz;
    
    protected EntityManager em() {
        return emp.get();
    }
    
    @Inject
    public AbstractDao(Provider<EntityManager> emf, Class<T> clazz) {
        this.emp = emf;
        this.clazz = clazz;
    }
    
    @Transactional
    public void save(T t) {
        if(t.getId() != null)
            t = em().merge(t);
        else
            em().persist(t);
    }
    
    public List<T> findAll() {
        TypedQuery<T> q = em().createQuery("select e from " + clazz.getSimpleName() + " e", clazz);
        return q.getResultList();
    }
    
    public T find(Long id) {
        return em().getReference(clazz, id);
    }
    
    @Transactional
    public void remove(T t) {
        em().remove(t);
    }
}
