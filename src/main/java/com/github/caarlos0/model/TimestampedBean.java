package com.github.caarlos0.model;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.caarlos0.model.listeners.TimestampListener;

/**
 * Provides the same behavior seen in {@link Bean} class, plus the ability to
 * have automagic createdAt and updatedAt attributes.
 * 
 * @author Carlos A Becker
 */
@MappedSuperclass
@EntityListeners({ TimestampListener.class })
public abstract class TimestampedBean extends Bean {
	private static final long serialVersionUID = 1L;

	public TimestampedBean() {
		super();
	}

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "TimestampedBean [createdAt=" + createdAt.getTime()
				+ ", updatedAt=" + updatedAt.getTime() + ", "
				+ super.toString() + "]";
	}

}