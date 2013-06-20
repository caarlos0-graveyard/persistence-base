package com.github.caarlos0.tests.model;

import javax.persistence.Entity;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.github.caarlos0.model.TimestampedBean;

@Entity
public class MyTimestampedBean extends TimestampedBean {

	private static final long serialVersionUID = 1L;

	private String foobar;

	public MyTimestampedBean() {
	}

	public MyTimestampedBean(String foobar) {
		super();
		this.foobar = foobar;
	}

	public String getFoobar() {
		return foobar;
	}

	public void setFoobar(String foobar) {
		this.foobar = foobar;
	}

	@PrePersist
	public void onPrePersist() {
		System.out.println("LOOK AT MY PRE PERSIST DUDE!");
		this.foobar = foobar + " - " + System.currentTimeMillis();
	}

	@PreUpdate
	public void onPreUpdate() {
		System.out.println("Look at me, I have my own pre update!");
	}

	@PostUpdate
	public void onPostUpdate() {
		System.out
				.println("Hi, I'm the postUpdate! My object is now like this: "
						+ toString());

	}

	@Override
	public String toString() {
		return "MyTimestampedBean [foobar=" + foobar + ", " + super.toString()
				+ "]";
	}

}
