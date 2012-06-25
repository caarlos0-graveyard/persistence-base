package com.github.caarlos0.inject;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * Utility class that will start the PersistService.
 *
 * @author Carlos A Becker
 */
public class PersistenceInitializer {

    @Inject
    public PersistenceInitializer(PersistService service) {
        service.start();
    }
    
}
