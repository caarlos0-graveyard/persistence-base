package com.github.caarlos0.model;

import com.github.caarlos0.interfaces.Bean;

import javax.persistence.*;

/**
 * @author: Carlos A Becker
 */
@MappedSuperclass
public abstract class BaseBean implements Bean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    protected BaseBean() {
    }

    protected BaseBean(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
