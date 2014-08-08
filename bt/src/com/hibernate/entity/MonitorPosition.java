package com.hibernate.entity;

import java.sql.Timestamp;

public class MonitorPosition {
	private MonitorPositionId id;

	// Constructors

	/** default constructor */
	public MonitorPosition() {
	}

	/** full constructor */
	public MonitorPosition(MonitorPositionId id) {
		this.id = id;
	}

	// Property accessors

	public MonitorPositionId getId() {
		return this.id;
	}

	public void setId(MonitorPositionId id) {
		this.id = id;
	}
}
