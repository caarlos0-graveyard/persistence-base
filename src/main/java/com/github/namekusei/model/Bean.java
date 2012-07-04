package com.github.namekusei.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Base class for all your Beans/Models/POJOs or whatever you want to call them.
 *
 * @author Carlos A Becker
 */
@MappedSuperclass
public abstract class Bean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Version
    private Long version;

    public Bean(Long id, Long version) {
        this.id = id;
        this.version = version;
    }

    public Bean() {
    }

    protected Bean(Long id) {
        this.id = id;
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
