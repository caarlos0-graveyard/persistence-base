package com.github.namekusei.tests;

import com.github.namekusei.model.Bean;

import javax.persistence.Entity;

/**
 * @author: Carlos A Becker
 */
@Entity
public class MyOtherBean extends Bean {

    public String name;

    public MyOtherBean() {
    }

    public MyOtherBean(String name) {
        this.name = name;
    }
}
