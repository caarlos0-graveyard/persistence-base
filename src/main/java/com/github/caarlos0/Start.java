package com.github.caarlos0;

import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.model.Pessoa;

import javax.inject.Inject;

public class Start {

    private final GenericDao<Pessoa> dao;

    @Inject
    public Start(GenericDao<Pessoa> dao) {
        this.dao = dao;

        System.out.println((dao != null) + " maoee");
    }
}
