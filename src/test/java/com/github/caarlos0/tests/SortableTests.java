package com.github.caarlos0.tests;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.github.caarlos0.tests.dao.SortableDao;
import com.github.caarlos0.tests.inject.TestModule;
import com.github.caarlos0.tests.model.SortableBean;
import com.github.caarlos0.tests.runner.GuiceTestRunner;
import com.github.caarlos0.tests.runner.GuiceTestRunner.GuiceModules;

@RunWith(GuiceTestRunner.class)
@GuiceModules(TestModule.class)
public class SortableTests {

	@Inject
	private SortableDao dao;

	@Test
	public void testSorting() {
		List<SortableBean> beans = Arrays.asList(new SortableBean(0),
				new SortableBean(1), new SortableBean(2), new SortableBean(3),
				new SortableBean(4));
		for (SortableBean bean : beans) {
			dao.save(bean);
		}

		System.out.println("BEFORE");
		for (SortableBean bean : dao.findAll()) {
			System.out.println("Sortable " + bean.getId() + " - "
					+ bean.getPosition() + " - " + bean.getVersion());
		}

		dao.move(beans.get(3), 0);

		System.out.println("AFTER");
		for (SortableBean bean : dao.findAll()) {
			System.out.println("Sortable " + bean.getId() + " - "
					+ bean.getPosition() + " - " + bean.getVersion());
		}
	}
}
