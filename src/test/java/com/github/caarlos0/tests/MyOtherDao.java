package com.github.caarlos0.tests;

import com.github.caarlos0.dao.Dao;

/**
 * @author: Carlos A Becker
 */
public interface MyOtherDao extends Dao<MyOtherBean> {
    public void foo();
}
