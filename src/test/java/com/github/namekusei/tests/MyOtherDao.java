package com.github.namekusei.tests;

import com.github.namekusei.dao.Dao;

/**
 * @author: Carlos A Becker
 */
public interface MyOtherDao extends Dao<MyOtherBean> {
    public void foo();
}
