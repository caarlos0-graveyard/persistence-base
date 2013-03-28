package com.github.caarlos0.tests;

import com.github.caarlos0.model.Bean;

import javax.persistence.Entity;

/**
 * @author: Carlos A Becker
 */
@Entity
public class MyOtherBean extends Bean {

	private static final long serialVersionUID = 1L;
	public String name;

    public MyOtherBean() {
    }

    public MyOtherBean(String name) {
        this.name = name;
    }
}
