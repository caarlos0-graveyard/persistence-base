package com.github.caarlos0.model;

import java.util.Date;

import javax.persistence.Column;
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
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
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

	private long getUpdatedAtTime() {
		if (updatedAt == null) {
			return -1L;
		}
		return updatedAt.getTime();
	}

	private long getCreatedAtTime() {
		if (createdAt == null) {
			return -1L;
		}
		return createdAt.getTime();
	}
	
	@Override
	public String toString() {
		return "TimestampedBean [createdAt=" + getCreatedAtTime()
				+ ", updatedAt=" + getUpdatedAtTime() + ", " + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimestampedBean other = (TimestampedBean) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}
}