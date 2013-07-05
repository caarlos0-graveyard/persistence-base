package com.github.caarlos0.inject;

import static com.google.common.base.Preconditions.checkArgument;

import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.model.Bean;
import com.google.inject.AbstractModule;
import com.google.inject.binder.ScopedBindingBuilder;

/**
 * An abstract Guice module that lets you bind a {@link GenericDao} to a type.
 * 
 * @author Carlos A Becker
 */
public abstract class AbstractPersistentModule extends AbstractModule {

	/**
	 * Creates a implementation of a {@link GenericDao} for the given type and
	 * made it managed by Guice.
	 * 
	 * @param type
	 *            the bean type which a GenericDao instance should be binded.
	 */
	protected <T extends Bean> ScopedBindingBuilder bindGenericDaoFor(
			Class<T> type) {
		checkArgument(type != null, "Type must not be null.");
		DaoTypeLiteralHelper<T> h = new DaoTypeLiteralHelper<T>(type);
		return bind(h.dao()).to(h.genericDao());
	}
}
