package com.github.caarlos0.inject;

import com.google.inject.persist.PersistService;

import javax.inject.Inject;

/**
 * Initialize the {@link PersistService}.
 * 
 * @author: Carlos A Becker
 */
public class PersistenceInitializer {

	/**
	 * This constructor will inject a {@link PersistService} instance and
	 * initialize it. So, just inject this class to automagically inject the
	 * {@link PersistService}.
	 * 
	 * @param service
	 */
	@Inject
	public PersistenceInitializer(PersistService service) {
		service.start();
	}
}
