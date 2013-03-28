package com.github.caarlos0.tests;

import com.github.caarlos0.inject.AbstractPersistentModule;
import com.github.caarlos0.inject.PersistenceModule;

/**
 * @author: Carlos A Becker
 */
public class TestModule extends AbstractPersistentModule {
	@Override
	protected void configure() {
		install(new PersistenceModule("caarlos0"));

		bindGenericDaoFor(MyBean.class);
		bind(MyOtherDao.class).to(MyOtherBeanDaoImpl.class);
	}
}
