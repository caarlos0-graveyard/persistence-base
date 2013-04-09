package com.github.caarlos0.tests.dao;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.tests.model.MyOtherBean;

/**
 * A Custom DAO interface.
 * 
 * @author: Carlos A Becker
 */
public interface MyOtherDao extends Dao<MyOtherBean> {
	
	/**
	 * says foo and return true.
	 */
	public boolean foo();
}
