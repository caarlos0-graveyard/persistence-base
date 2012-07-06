package com.github.namekusei.tests;

import com.github.namekusei.model.Bean;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author: Carlos A Becker
 */
@Entity
public class MyBean extends Bean {

    public String foo, bar;

    @Temporal(value = TemporalType.TIMESTAMP)
    public Date d;

    public MyBean() {
    }

    public MyBean(String bar, Date d, String foo) {
        this.bar = bar;
        this.d = d;
        this.foo = foo;
    }
}
