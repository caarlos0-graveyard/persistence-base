package com.github.namekusei.tests;

import com.github.namekusei.inject.AbstractPersistentModule;
import com.github.namekusei.inject.PersistenceModule;

/**
 * @author: Carlos A Becker
 */
public class TestModule extends AbstractPersistentModule {
	@Override
	protected void configure() {
		install(new PersistenceModule("namekusei"));
		
		bindGenericDaoFor(MyBean.class);
		bind(MyOtherDao.class).to(MyOtherBeanDaoImpl.class);
	}
}
