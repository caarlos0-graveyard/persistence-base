package com.github.caarlos0.tests.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.github.caarlos0.model.TimestampedBean;

@Entity
@Table(name = "sortables")
@NamedQueries({
		@NamedQuery(name = "SortableBean.findAll", query = "select s from SortableBean s order by s.position"),
		@NamedQuery(name = "SortableBean.updatePositions", query = "update SortableBean s set s.position = s.position + 1 where s.position >= :initialPosition and s.position < :finalPosition") })
public class SortableBean extends TimestampedBean {

	private static final long serialVersionUID = 1L;

	@Column(name = "pos", nullable = false)
	private Integer position;

	public SortableBean() {
	}

	public SortableBean(Integer position) {
		super();
		this.position = position;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@PrePersist
	public void setPosition() {
		if (position == null) {
			position = -1;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		SortableBean other = (SortableBean) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	
	
	
}
