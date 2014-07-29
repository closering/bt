package com.hibernate.entity;

import java.sql.Timestamp;

/**
 * LocusinfoId entity. @author MyEclipse Persistence Tools
 */

public class LocusinfoId implements java.io.Serializable {

	// Fields

	private String username;
	private Long id;
	private Double x;
	private Double y;
	private Long serial;
	private Timestamp datePhone;
	private Timestamp dateServer;

	// Constructors

	/** default constructor */
	public LocusinfoId() {
	}

	/** minimal constructor */
	public LocusinfoId(String username, Long id, Double x, Double y, Long serial) {
		this.username = username;
		this.id = id;
		this.x = x;
		this.y = y;
		this.serial = serial;
	}

	/** full constructor */
	public LocusinfoId(String username, Long id, Double x, Double y,
			Long serial, Timestamp datePhone, Timestamp dateServer) {
		this.username = username;
		this.id = id;
		this.x = x;
		this.y = y;
		this.serial = serial;
		this.datePhone = datePhone;
		this.dateServer = dateServer;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Long getSerial() {
		return this.serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	public Timestamp getDatePhone() {
		return this.datePhone;
	}

	public void setDatePhone(Timestamp datePhone) {
		this.datePhone = datePhone;
	}

	public Timestamp getDateServer() {
		return this.dateServer;
	}

	public void setDateServer(Timestamp dateServer) {
		this.dateServer = dateServer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LocusinfoId))
			return false;
		LocusinfoId castOther = (LocusinfoId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getX() == castOther.getX()) || (this.getX() != null
						&& castOther.getX() != null && this.getX().equals(
						castOther.getX())))
				&& ((this.getY() == castOther.getY()) || (this.getY() != null
						&& castOther.getY() != null && this.getY().equals(
						castOther.getY())))
				&& ((this.getSerial() == castOther.getSerial()) || (this
						.getSerial() != null && castOther.getSerial() != null && this
						.getSerial().equals(castOther.getSerial())))
				&& ((this.getDatePhone() == castOther.getDatePhone()) || (this
						.getDatePhone() != null
						&& castOther.getDatePhone() != null && this
						.getDatePhone().equals(castOther.getDatePhone())))
				&& ((this.getDateServer() == castOther.getDateServer()) || (this
						.getDateServer() != null
						&& castOther.getDateServer() != null && this
						.getDateServer().equals(castOther.getDateServer())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + (getX() == null ? 0 : this.getX().hashCode());
		result = 37 * result + (getY() == null ? 0 : this.getY().hashCode());
		result = 37 * result
				+ (getSerial() == null ? 0 : this.getSerial().hashCode());
		result = 37 * result
				+ (getDatePhone() == null ? 0 : this.getDatePhone().hashCode());
		result = 37
				* result
				+ (getDateServer() == null ? 0 : this.getDateServer()
						.hashCode());
		return result;
	}

}