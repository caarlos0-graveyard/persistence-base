package com.github.caarlos0.tests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.tests.inject.TestModule;
import com.github.caarlos0.tests.model.MyTimestampedBean;
import com.github.caarlos0.tests.runner.GuiceTestRunner;
import com.github.caarlos0.tests.runner.GuiceTestRunner.GuiceModules;
import com.google.inject.Inject;

@GuiceModules(TestModule.class)
@RunWith(GuiceTestRunner.class)
public class CallbackTests {

	@Inject
	private Dao<MyTimestampedBean> dao;

	/**
	 * it should fill createdAt and updatedAt at persist.
	 */
	@Test
	public void testPrePersist() {
		MyTimestampedBean t = new MyTimestampedBean("test01");
		t = dao.save(t);
		assertNotNull(t.getCreatedAt());
		assertNotNull(t.getUpdatedAt());
	}

	/**
	 * it should refill updatedAt at update.
	 */
	@Test
	public void testPreUpdate() {
		MyTimestampedBean t = new MyTimestampedBean("test02");
		t = dao.save(t);
		Date previousUpdatedAt = t.getUpdatedAt();
		t.setFoobar("test02.1");
		t = dao.save(t);
		assertNotEquals(t.getUpdatedAt(), previousUpdatedAt);
	}
}
