package com.github.caarlos0.inject;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * The persistence module for Guice.
 *
 * @author Carlos A Becker
 */
public class PersistenceModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new JpaPersistModule("base")); // base has to be the PU in persistence.xml
        
        bind(PersistenceInitializer.class);
    }
    
}
