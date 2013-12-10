package com.github.caarlos0.tests.dao;

import static com.google.common.collect.Ordering.natural;
import static java.util.Arrays.asList;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.tests.model.SortableBean;
import com.google.common.collect.Ordering;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.persist.Transactional;

public class SortableDaoImpl extends GenericDao<SortableBean> implements
		SortableDao {

	@Inject
	protected SortableDaoImpl(TypeLiteral<SortableBean> type,
			Provider<EntityManager> emp) {
		super(type, emp);
	}

	@Transactional
	@Override
	public void move(SortableBean sortable, int newPosition) {
		final int oldPosition = sortable.getPosition();
		if (newPosition != oldPosition) {
			final List<Integer> positions = asList(newPosition, oldPosition);
			final Ordering<Integer> ordering = natural();
			System.out.println("INITIAL=" + ordering.min(positions) + " FINAL="
					+ ordering.max(positions));
			int count = em().createNamedQuery("SortableBean.updatePositions")
					.setParameter("initialPosition", ordering.min(positions))
					.setParameter("finalPosition", ordering.max(positions))
					.executeUpdate();
			System.out.println("UPDATED " + count + " ITEMS");
			sortable.setPosition(newPosition);
			save(sortable);
		}
	}

	@Override
	public List<SortableBean> findAll() {
		return em()
				.createNamedQuery("SortableBean.findAll", SortableBean.class)
				.getResultList();
	}

}
