package com.github.caarlos0.tests.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.tests.model.MyOtherBean;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/**
 * A Custom DAO Implementation.
 * 
 * @author: Carlos A Becker
 */
public class MyOtherBeanDaoImpl extends GenericDao<MyOtherBean> implements
		MyOtherDao {
	@Inject
	protected MyOtherBeanDaoImpl(TypeLiteral<MyOtherBean> type,
			Provider<EntityManager> emp) {
		super(type, emp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.github.caarlos0.tests.dao.MyOtherDao#foo()
	 */
	@Override
	public boolean foo() {
		System.out.println("Foooo...");
		return true;
	}
}
