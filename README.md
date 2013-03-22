namekusei / persistence
================

### Tecnologies

A base for all your persistence projects, build in top of:

* EclipseLink and JPA2
* Apache B-Val (bean validation)
* Google Guice
* Apache Maven

### Providing

* A `MappedSuperclass` with `@Id` and `@Version` (see the `Bean` class);
* A `GenericDao` that provide basic CRUD operations out of the box;
* An `AbstractPersistentModule` to you extend and do things like:
  
  // module setup
  bindGenericDaoFor(MyBean.class);

And guice will automagically provide a `GenericDao<MyBean>` to you, so you can inject like this:

  // some class
  @Inject Dao<MyBean> myBeanDao;


The `AbstractPersistentModule` will also startup the PersistenceService (Guice-Persist setup).

### How-to use

coming soon...



-------------

You take a look at [this old tutorial of the old project](http://caarlos0.github.com/code/2012/06/25/modular-persistence).

