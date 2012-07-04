package com.github.caarlos0.inject;

import com.github.caarlos0.dao.GenericDao;

import javax.inject.Provider;

/**
 * @author: Carlos A Becker
 */
public class GenericDaoProvider implements Provider<GenericDao> {
    @Override
    public GenericDao get() {
        return null;
    }
}
