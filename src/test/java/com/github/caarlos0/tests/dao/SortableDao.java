package com.github.caarlos0.tests.dao;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.tests.model.SortableBean;

public interface SortableDao extends Dao<SortableBean> {
	
	public void move(SortableBean b, int pos);
}
