package com.github.caarlos0.model.listeners;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.github.caarlos0.model.TimestampedBean;

/**
 * Callbacks from {@link TimestampedBean}.
 * 
 * Fill in createdAt and updatedAt in their respective callbacks.
 * 
 * @author Carlos A Becker
 */
public class TimestampListener {

	@PrePersist
	public void onPrePersist(TimestampedBean bean) {
		bean.setCreatedAt(new Date());
		bean.setUpdatedAt(new Date());
	}

	@PreUpdate
	public void onPreUpdate(TimestampedBean bean) {
		bean.setUpdatedAt(new Date());
	}
}
