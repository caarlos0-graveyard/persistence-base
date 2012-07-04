package com.github.caarlos0.model;

/**
 * @author: Carlos A Becker
 */
public class FooEntity extends Bean {

    private String foo;

    public FooEntity(String foo) {
        this.foo = foo;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
}
