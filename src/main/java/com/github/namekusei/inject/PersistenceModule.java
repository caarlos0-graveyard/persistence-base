package com.github.namekusei.inject;

import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * The adapted persistence module for Guice-Persist.
 *
 * @author Carlos A Becker
 */
public class PersistenceModule extends AbstractModule {

    private final String pu;

    public PersistenceModule(String pu) {
        this.pu = pu;
    }

    @Override
    protected void configure() {
        install(new JpaPersistModule(pu));
        bind(PersistenceInitializer.class);
    }

}
