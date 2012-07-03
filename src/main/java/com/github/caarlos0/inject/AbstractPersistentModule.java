package com.github.caarlos0.inject;

import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.helper.PersistenceHelper;
import com.github.caarlos0.model.Bean;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.util.Types;

public abstract class AbstractPersistentModule extends AbstractModule {

    private static <T extends Bean> Key<GenericDao<T>> forClazz(Class<T> type) {
        return (Key<GenericDao<T>>) Key.get(Types.newParameterizedType(GenericDao.class, type));
    }

    private static <T extends Bean> GenericDao<T> dao(final Class<T> type) {
        GenericDao<T> dao = new GenericDao<T>() {
            @Override
            protected Class<T> clazz() {
                return type;
            }
        };
        return dao;
    }

    protected <T extends Bean> void bindGenericDao(Class<T> type) {
        GenericDao<T> dao = dao(type);
        requestInjection(dao);
        bind(forClazz(type)).toInstance(dao);
    }
}
