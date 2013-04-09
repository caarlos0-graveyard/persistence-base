package com.github.caarlos0.tests.inject;

import com.github.caarlos0.inject.AbstractPersistentModule;
import com.github.caarlos0.inject.PersistenceModule;
import com.github.caarlos0.tests.dao.MyOtherBeanDaoImpl;
import com.github.caarlos0.tests.dao.MyOtherDao;
import com.github.caarlos0.tests.model.MyBean;

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
