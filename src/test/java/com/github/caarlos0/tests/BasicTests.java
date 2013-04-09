package com.github.caarlos0.tests;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import java.util.Date;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.tests.dao.MyOtherDao;
import com.github.caarlos0.tests.inject.TestModule;
import com.github.caarlos0.tests.model.MyBean;
import com.github.caarlos0.tests.model.MyOtherBean;
import com.github.caarlos0.tests.runner.GuiceTestRunner;
import com.github.caarlos0.tests.runner.GuiceTestRunner.GuiceModules;

/**
 * Test basic DAO injection and save beans.
 * 
 * @author: Carlos A Becker
 */
@RunWith(GuiceTestRunner.class)
@GuiceModules(TestModule.class)
public class BasicTests {

	@Inject
	private Dao<MyBean> dao;

	@Inject
	private MyOtherDao otherDao;

	/**
	 * testing a generic dao injection...
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGenericDao() throws Exception {
		MyBean b = dao.save(new MyBean("a bar", new Date(), "a foo"));
		assertNotNull(b.getId());
	}

	/**
	 * testing a custom dao injection...
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOtherDao() throws Exception {
		MyOtherBean b = otherDao.save(new MyOtherBean("some name"));
		assertNotNull(b.getId());
	}

	@Test
	public void testCustomMethod() {
		assertTrue(otherDao.foo());
	}
}
