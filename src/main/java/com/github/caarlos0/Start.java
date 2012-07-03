package com.github.caarlos0;

import com.github.caarlos0.dao.AbstractDao;
import com.github.caarlos0.model.Pessoa;

import javax.inject.Inject;

public class Start {

    private final AbstractDao<Pessoa> dao;

    @Inject
    public Start(AbstractDao<Pessoa> dao) {
        this.dao = dao;

        System.out.println((dao != null) + " maoee");
    }
}
