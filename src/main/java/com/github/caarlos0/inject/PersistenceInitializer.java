package com.github.caarlos0.inject;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * @author: Carlos A Becker
 */
public class PersistenceInitializer {

    @Inject
    public PersistenceInitializer(PersistService service) {
        System.out.println("Starting persistence service...");
        service.start();
    }

}
