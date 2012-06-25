package com.github.caarlos0.helper;

import com.github.caarlos0.inject.PersistenceInitializer;
import com.github.caarlos0.inject.PersistenceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * @author carlos
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
    