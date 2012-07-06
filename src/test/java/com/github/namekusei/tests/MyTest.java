package com.github.namekusei.tests;

import com.github.namekusei.dao.Dao;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author: Carlos A Becker
 */
public class MyTest {

    Injector i = Guice.createInjector(new TestModule());

    Dao<MyBean> dao = i.getInstance(Key.get(new TypeLiteral<Dao<MyBean>>(){}));
    MyOtherDao otherDao = i.getInstance(MyOtherDao.class);

    @Test
    public void testGenericDao() throws Exception {
        MyBean b = new MyBean("maoe", new Date(), "ma vaaeee");
        dao.save(b);
        Assert.assertNotNull(b.getId());
    }

    @Test
    public void testOtherDao() throws Exception {
        MyOtherBean b = new MyOtherBean("eoee");
        otherDao.save(b);
        Assert.assertNotNull(b.getId());
    }
}
