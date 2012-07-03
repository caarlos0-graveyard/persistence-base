package com.github.caarlos0.dao;


import com.github.caarlos0.model.Bean;

public class GenericDao<T extends Bean> extends AbstractDao<T> {

    @Override
    protected Class<T> clazz() {
        return null;
    }
}
