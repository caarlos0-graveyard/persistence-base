package com.github.caarlos0.dao;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.github.caarlos0.model.Bean;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.Transactional;

/* @formatter:off */
/**
 * Create your specific DAO extending this class, overriding the
 * constructor like the example above:
 * <p/>
 * <code>
 * public class FooDaoImpl extends GenericDao<Foo> implements FooDao {
 * 	@Inject public FooDaoImpl(TypeLiteral<Foo> type, 
 * 		Provider<EntityManager> emp) {
 * 		super(type, emp);
 * 	}
 * }
 * </code>
 * <p/>
 * In this case, <i>Foo</i> has to extend <code>Bean</code>.
 * 
 * @author Carlos A Becker
 */
/* @formatter:on */
public class GenericDao<T extends Bean> implements Dao<T> {

	private final Provider<EntityManager> emp;
	private final Class<T> clazz;

	/**
	 * Override this constructor to in your specific DAO.
	 * 
	 * @param type
	 * @param emp
	 */
	@SuppressWarnings("unchecked")
	@Inject
	protected GenericDao(TypeLiteral<T> type, Provider<EntityManager> emp) {
		checkArgument(type != null, "type must not be null.");
		this.clazz = (Class<T>) type.getRawType();
		this.emp = emp;
	}

	/**
	 * This will get an EntityManager instance from EntityManagerProvider.
	 * 
	 * @return an entity manager instance ready to use.
	 */
	protected EntityManager em() {
		return emp.get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.caarlos0.dao.Dao#save(com.github.caarlos0.model.Bean)
	 */
	@Override
	@Transactional
	public T save(T t) {
		checkNotNull(t, "Object (t) to save must not be null.");
		if (t.getId() != null) {
			t = em().merge(t);
		} else {
			em().persist(t);
		}
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.caarlos0.dao.Dao#findAll()
	 */
	@Override
	public List<T> findAll() {
		TypedQuery<T> q = em().createQuery(
				"select e from " + clazz.getSimpleName() + " e", clazz);
		return q.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.caarlos0.dao.Dao#find(java.lang.Long)
	 */
	@Override
	public T find(Long id) {
		checkNotNull(id, "Given ID must not be null.");
		return em().getReference(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.caarlos0.dao.Dao#remove(com.github.caarlos0.model.Bean)
	 */
	@Override
	@Transactional
	public void remove(T t) {
		checkNotNull(t, "Object (t) to delete must not be null.");
		em().remove(t);
	}
}
