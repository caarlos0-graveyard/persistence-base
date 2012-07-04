package com.github.caarlos0.inject;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.model.Bean;
import com.google.common.base.Preconditions;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.util.Types;

import java.lang.reflect.Type;

/**
 * A abstract Guice module that lets you bind a {@link GenericDao} to a type.
 *
 * @author Carlos A Becker
 */
public abstract class AbstractPersistentModule extends AbstractModule {

    /**
     * Creates a implementation of a {@link GenericDao} for the given type and made it managed by guice.
     *
     * @param type bean type to let inject a genericdao.
     * @param <T>
     */
    protected <T extends Bean> ScopedBindingBuilder bindGenericDao(Class<T> type) {
        Preconditions.checkArgument(type != null, "Type must not be null.");

        return new DaoTypeLiteralHelper<T>(type).bind();
    }

    private class DaoTypeLiteralHelper<T extends Bean> {

        private Class<T> type;

        private DaoTypeLiteralHelper(Class<T> type) {
            this.type = type;
        }

        private ScopedBindingBuilder bind() {
            return AbstractPersistentModule.this.bind(dao()).to(genericDao());
        }

        private <T> TypeLiteral<T> dao() {
            return (TypeLiteral) TypeLiteral.get(Types.newParameterizedType(Dao.class, type));
        }

        private <T extends Bean> TypeLiteral<T> genericDao() {
            return (TypeLiteral) TypeLiteral.get(Types.newParameterizedType(GenericDao.class, type, getKey()));
        }

        private Type getKey() {
            return Key.get(type).getClass();
        }
    }
}
