package com.github.namekusei.tests;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.github.namekusei.dao.GenericDao;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

/**
 * @author: Carlos A Becker
 */
public class MyOtherBeanDaoImpl extends GenericDao<MyOtherBean> implements MyOtherDao {
    @Inject
    protected MyOtherBeanDaoImpl(TypeLiteral<MyOtherBean> type, Provider<EntityManager> emp) {
        super(type, emp);
    }

    public void foo(){
        System.out.println("FOooo");
    }
}
