package com.github.caarlos0.inject;

import com.github.caarlos0.Start;
import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.model.Pessoa;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * The persistence module for Guice.
 *
 * @author Carlos A Becker
 */
public class PersistenceModule extends AbstractPersistentModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("base")); // base has to be the PU in persistence.xml
        
        bind(PersistenceInitializer.class);

        bind(Start.class);

        bindGenericDao(Pessoa.class);

    }
    
}
