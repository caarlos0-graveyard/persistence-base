package com.github.caarlos0.dao;

import com.github.caarlos0.model.Bean;

import java.util.List;

/**
 * Create your custom DAO interfaces extending this one, and you custom DAO
 * implementation should implement your custom DAO interface also.
 * 
 * @author: Carlos A Becker
 */
public interface Dao<T extends Bean> {

	/**
	 * Persist the given entity into through EntityManager.
	 * 
	 * @param t
	 *            entity to be saved.
	 */
	public T save(T t);

	/**
	 * Find all items of this type in the database.
	 * 
	 * @return a List of T elements from database.
	 */
	public List<T> findAll();

	/**
	 * Find an item from database based on its ID.
	 * 
	 * @param id
	 *            to look for.
	 * @return found entity or null if no entity is found.
	 */
	public T find(Long id);

	/**
	 * Delete the item from database.
	 * 
	 * @param t
	 *            item to delete.
	 */
	public void remove(T t);
}
