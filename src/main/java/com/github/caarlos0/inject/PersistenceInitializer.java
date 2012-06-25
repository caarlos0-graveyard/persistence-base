/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.caarlos0.inject;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 *
 * @author carlos
 */
public class PersistenceInitializer {

    @Inject
    public PersistenceInitializer(PersistService service) {
        service.start();
    }
    
}
