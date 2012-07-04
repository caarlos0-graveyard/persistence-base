package com.github.namekusei.inject;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * @author: Carlos A Becker
 */
public class PersistenceInitializer {

    @Inject
    public PersistenceInitializer(PersistService service) {
        service.start();
    }

}
