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

        // forcing it as a eager singleton, so it will start automagically with the app..
        bind(PersistenceInitializer.class).asEagerSingleton();
    }

}
