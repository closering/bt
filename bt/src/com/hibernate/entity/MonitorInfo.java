package com.hibernate.entity;


import java.sql.Timestamp;
import java.util.Date;

public class MonitorInfo implements java.io.Serializable {

	
	private MonitorInfoId id;
	private Double x;
	private Double y;
	private Double radius;
	private Timestamp setDate;
	
	public MonitorInfo() {
	}

	/** full constructor */
	public MonitorInfo(MonitorInfoId id, Double x, Double y, Double radius,
			Timestamp setDate) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.setDate = setDate;
		
	}
	
	
	
	public MonitorInfoId getId() {
		return id;
	}

	public void setId(MonitorInfoId id) {
		this.id = id;
	}

	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Timestamp getSetDate() {
		return setDate;
	}
	public void setSetDate(Timestamp setDate) {
		this.setDate = setDate;
	}
		
	
}
