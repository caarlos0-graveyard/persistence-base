package com.github.namekusei.dao;

import com.github.namekusei.model.Bean;

import java.util.List;

/**
 * @author: Carlos A Becker
 */
public interface Dao<T extends Bean> {

    public void save(T t);

    public List<T> findAll();

    public T find(Long id);

    public void remove(T t);
}
