package com.github.caarlos0.inject;

import com.github.caarlos0.dao.AbstractDao;
import com.github.caarlos0.model.Bean;
import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.util.Types;

public abstract class AbstractPersistentModule extends AbstractModule {

    static <T extends Bean> Key<AbstractDao<T>> forClazz(Class<T> type) {
        return (Key<AbstractDao<T>>) Key.get(Types.newParameterizedType(AbstractDao.class, type));
    }
}
