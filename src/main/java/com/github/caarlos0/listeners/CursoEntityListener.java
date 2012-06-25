package com.github.caarlos0.listeners;

import com.github.caarlos0.model.Curso;

import javax.persistence.*;

/**
 * @author: Carlos A Becker
 */
public class CursoEntityListener {
    @PrePersist
    public void prePersistCursoEvent(Curso curso) {
        System.out.println("PrePersist: " + curso);
    }

    @PostPersist
    public void postPersistEvent(Curso curso) {
        System.out.println("PostPersist: " + curso);
    }

    @PreUpdate
    public void preUpdateCursoEvent(Curso curso) {
        System.out.println("PreUpdate: " + curso);
    }

    @PostUpdate
    public void postUpdateCursoEvent(Curso curso) {
        System.out.println("PostUpdate: " + curso);
    }

    @PreRemove
    public void preRemoveCursoEvent(Curso curso) {
        System.out.println("PreRemove: " + curso);
    }

    @PostRemove
    public void postRemoveCursoEvent(Curso curso) {
        System.out.println("PostRemove: " + curso);
    }

    @PostLoad
    public void postLoadCursoEvent(Curso curso) {
        System.out.println("PostLoad: " + curso);
    }
}
