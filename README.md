persistence-base
================

### Why did I built this?

In my post-graduation classes, I had to build a lot of simple projects
with only persistence in one grade. So, I built this because I'm lazy.

### Tecnology

This project is built on top of the following tecnologies:

* EclipseLink and JPA2

  EclipseLink is the reference implementation of JPA2 (JSR-317)
  specification. I also found it a bit faster and "ligher" than
  other ORMs, like Hibernate.

* Apache B-Val

  Implementation (not sure if is the reference one) of the JSR-303, which
  _a meta-data model and API for JavaBeanTM validation based on defines
  annotations, with overrides and extended meta-data through the use of
  XML validation descriptors."_

* Google Guice

  Reference Implementation of the JSR-330, which helps _"to maximize reusability,
  testability and maintainability of Java code by standardizing an extensible
  dependency injection API"_.

* Google Guava APIs

  A set of utility classes to made you write less code. You might want to take
  a loot at [this][guava].

* JUnit

  For tests pourposes.

* Apache Maven

  You know that it is.


### What we provide

We provide a set of useful classes which you can use to bootstrap your
persistence project:

* A `MappedSuperclass` with `@Id` and `@Version` (see the `Bean` class);
* A `GenericDao` that provide basic CRUD operations out of the box;
* An `AbstractPersistentModule` to you extend and do things like:

```java
// module setup
bindGenericDaoFor(MyBean.class);
```

And guice will automagically provide a `GenericDao<MyBean>` to you, so you can
inject like this:

```java
// some class
@Inject Dao<MyBean> myBeanDao;
```

You can also do something like

```java
bind(MyOtherDao.class).to(MyOtherBeanDaoImpl.class);
```

in your module, and then, somewhere, just _inject_ it:

```java
@Inject MyOtherDao myOtherDao;
```

And then use it like a boss.


The `AbstractPersistentModule` will also startup the PersistenceService
(Guice-Persist setup).

### How-to use

> comming soon (?)

I recommend you to read the sources of the tests. It's a complete basic example,
you should use it as a "light" for you.


### Recommended use

You can use this project as a base for you school project, or any other app.
I'll recommend you to read the sources, and, change anything to adapts to what
you may need.

For school projects, it should be good enought in it's actual state. Just clone,
rename and put the horses to work on what really matter.

-------------

You might want to take a look at [this old tutorial of an old revision][1] of
this project (you may want to use it at [0.0.1][2] tag).

[1]: http://caarlos0.github.com/posts/modular-persistence/
[2]: https://github.com/caarlos0/persistence-base/tree/v0.0.1
[guava]: http://caarlos0.github.com/posts/rocking-out-with-google-guava/
