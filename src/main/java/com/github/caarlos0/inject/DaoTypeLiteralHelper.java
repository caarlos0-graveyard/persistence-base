package com.github.caarlos0.inject;

import com.github.caarlos0.dao.Dao;
import com.github.caarlos0.dao.GenericDao;
import com.github.caarlos0.model.Bean;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import java.lang.reflect.Type;

/**
 * Helper Class for GenericDAO bindings.
 *
 * @author Carlos A. Becker
 *
 * @param <T>
 */
public class DaoTypeLiteralHelper<T extends Bean> {

	private Class<T> type;

	/**
	 * @param type: the model which should be binded to GenericDao;
	 */
	public DaoTypeLiteralHelper(Class<T> type) {
		this.type = type;
	}

	/**
	 * Build the Dao<T> TypeLiteral and return
	 * 
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings({"hiding", "unchecked"})
	public <T> TypeLiteral<T> dao() {
		return (TypeLiteral<T>) TypeLiteral.get(Types.newParameterizedType(
						Dao.class, type));
	}

	/**
	 * Build the GenericDao<T> TypeLiteral and return
	 *
	 * @param <T>
	 * @return
	 */
	@SuppressWarnings({"hiding", "unchecked"})
	public <T extends Bean> TypeLiteral<T> genericDao() {
		return (TypeLiteral<T>) TypeLiteral.get(Types.newParameterizedType(
						GenericDao.class, type, getKey()));
	}

	private Type getKey() {
		return Key.get(type).getClass();
	}
}
