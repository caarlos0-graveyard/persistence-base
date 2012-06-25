package com.github.caarlos0.helper;

import com.github.caarlos0.inject.PersistenceInitializer;
import com.github.caarlos0.inject.PersistenceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Helper class to get a Singleton of the PersistenceModule.
 *
 * @author Carlos A Becker
 */
public class PersistenceHelper {
    
    private static Injector inj;
    
    public static Injector getInjector() {
        if(inj == null) {
            inj = Guice.createInjector(new PersistenceModule());
            inj.getInstance(PersistenceInitializer.class);
        }
        return inj;
    }
    
}
    