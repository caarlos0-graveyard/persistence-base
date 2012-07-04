package com.github.caarlos0;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.inject.AbstractPersistentModule;
import com.github.caarlos0.inject.PersistenceInitializer;
import com.github.caarlos0.inject.PersistenceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Unit test for simple App.
 */
public class AppTest {


    {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            Enumeration<URL> e = loader.getResources("META-INF/persistence.xml");
            while (e.hasMoreElements()) {
                System.out.println(e.nextElement());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Injector i = Guice.createInjector(new PersistenceModule("base"), new AbstractPersistentModule() {
        @Override
        protected void configure() {
            bindGenericDao(FooEntity.class);
        }
    });

    PersistenceInitializer pi = i.getInstance(PersistenceInitializer.class);
    private Dao<FooEntity> dao = i.getInstance(Key.get(new TypeLiteral<Dao<FooEntity>>() {
    }));

    {
        System.out.println(dao != null);
        System.out.println(dao.getClass());
    }

    @Test
    public void testNotNull() {
        Assert.assertNotNull("dao esta null, nao injetou corretamente.", dao);
    }

    @Test
    public void testInsert() {
        FooEntity foo = new FooEntity("base");
        dao.save(foo);
        Assert.assertNotNull("id null, save error.", foo.getId());
    }
}
