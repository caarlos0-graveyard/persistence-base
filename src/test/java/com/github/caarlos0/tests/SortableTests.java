package com.github.caarlos0.tests;

import static com.google.common.collect.FluentIterable.from;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;

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

		List<SortableBean> beforeItens = dao.findAll();
		dao.move(beans.get(3), 0);
		List<SortableBean> afterItens = dao.findAll();

		// order must be changed, so it should be different.
		assertNotEquals("Order of ids must have been changed",
				toIdList(beforeItens), toIdList(afterItens));

		assertEquals("It should not have duplicated positions",
				removeDuplicates(toPositionList(beforeItens)).size(),
				removeDuplicates(toPositionList(afterItens)).size());
	}

	private <T> List<T> removeDuplicates(List<T> itens) {
		return ImmutableSet.copyOf(itens).asList();
	}

	private List<Long> toIdList(List<SortableBean> itens) {
		return from(itens).transform(new IdFunction()).toList();
	}

	private List<Integer> toPositionList(List<SortableBean> itens) {
		return from(itens).transform(new PositionFunction()).toList();
	}

	private class IdFunction implements Function<SortableBean, Long> {
		@Override
		public Long apply(SortableBean bean) {
			return bean.getId();
		}
	}

	private class PositionFunction implements Function<SortableBean, Integer> {
		@Override
		public Integer apply(SortableBean bean) {
			return bean.getPosition();
		}
	}
}
