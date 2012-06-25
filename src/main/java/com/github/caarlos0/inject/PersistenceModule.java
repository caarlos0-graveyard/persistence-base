package com.github.caarlos0.inject;

import com.github.caarlos0.dao.AlunoDao;
import com.github.caarlos0.dao.CursoDao;
import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 *
 * @author Carlos A Becker
 */
public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("ex03"));
        
        bind(PersistenceInitializer.class);
        bind(CursoDao.class);
        bind(AlunoDao.class);
    }
    
}
