package com.github.caarlos0.inject;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.model.Bean;
import com.google.common.base.Preconditions;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;

/**
 * A abstract Guice module that lets you bind a {@link GenericDao} to a type.
 *
 * @author Carlos A Becker
 */
public abstract class AbstractPersistentModule extends AbstractModule {

//    /**
//     * Helper class.
//     *
//     * @author Carlos A Becker
//     *
//     * @param <T>
//     */
//    private class GenericDaoInjectionHelper<T extends Bean> {
//        private final Class<T> clazz;
//
//        private GenericDaoInjectionHelper(Class<T> clazz) {
//            this.clazz = clazz;
//        }
//
//        private Key<GenericDao<T>> forClazz() {
//            return (Key<GenericDao<T>>) Key.get(Types.newParameterizedType(GenericDao.class, clazz));
//        }
//
//        private Key<GenericDao<T>> dao() {
//
//            GenericDao<T> dao = get;
//
//        }
//    }

    /**
     * Creates a implementation of a {@link GenericDao} for the given type and made it managed by guice.
     *
     * @param type bean type to let inject a genericdao.
     * @param <T>
     */
    protected <T extends Bean> void bindGenericDao(Class<T> type) {
        Preconditions.checkArgument(type != null, "Type must not be null.");

//        GenericDaoInjectionHelper<T> helper = new GenericDaoInjectionHelper<T>(type);
//        bind(helper.forClazz()).to(helper.dao());

        bind(
                (TypeLiteral) TypeLiteral.get(Types.newParameterizedType(
                        Dao.class, type))).to(
                (TypeLiteral) TypeLiteral.get(Types.newParameterizedType(
                        GenericDao.class,
                        type, Key.get(type).getClass()))
        );


//        bind(
//                TypeLiteral.get(Types.newParameterizedType(Dao.class, type))
//        ).to(
//                TypeLiteral.get(Types.newParameterizedType(GenericDao.class, type))
//        );

    }
}
