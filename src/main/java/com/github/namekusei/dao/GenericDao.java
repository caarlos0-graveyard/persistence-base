package com.github.namekusei.dao;

import com.github.namekusei.model.Bean;
import com.google.common.base.Preconditions;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Create your specific DAO extending this class, override the constructor ths way:
 * <p/>
 * <code>
 * public class CursoDao extends GenericDao<Foo> {
 *
 * @author Carlos A Becker
 * @Inject public CursoDao(Provider<EntityManager> emf) {
 * super(emf, Foo.class);
 * }
 * }
 * </code>
 * <p/>
 * In this case, <i>Foo</i> has to extend <code>Bean</code>.
 */
public class GenericDao<T extends Bean> implements Dao<T> {

    private final Provider<EntityManager> emp;
    private final Class<T> clazz;

    @Inject
    protected GenericDao(TypeLiteral<T> type, Provider<EntityManager> emp) {
        Preconditions.checkArgument(type != null, "type must not be null.");
        this.clazz = (Class<T>) type.getRawType();
        this.emp = emp;
    }

    protected EntityManager em() {
        return emp.get();
    }

    @Transactional
    public void save(T t) {
        if (t.getId() != null) {
            t = em().merge(t);
        } else {
            em().persist(t);
        }
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
