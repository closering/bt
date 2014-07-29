package com.hibernate.entity;

import java.sql.Timestamp;

/**
 * Biduid2scanId entity. @author MyEclipse Persistence Tools
 */

public class Biduid2scanId implements java.io.Serializable {

	// Fields

	private String uid;
	private String bid;
	private Timestamp scanDate;
	private Double x;
	private Double y;
	private String username;
	private Integer isMatch;
	private Integer operationType;

	// Constructors

	/** default constructor */
	public Biduid2scanId() {
	}

	/** minimal constructor */
	public Biduid2scanId(String uid, String bid, Double x, Double y,
			String username, Integer isMatch, Integer operationType) {
		this.uid = uid;
		this.bid = bid;
		this.x = x;
		this.y = y;
		this.username = username;
		this.isMatch = isMatch;
		this.operationType = operationType;
	}

	/** full constructor */
	public Biduid2scanId(String uid, String bid, Timestamp scanDate, Double x,
			Double y, String username, Integer isMatch, Integer operationType) {
		this.uid = uid;
		this.bid = bid;
		this.scanDate = scanDate;
		this.x = x;
		this.y = y;
		this.username = username;
		this.isMatch = isMatch;
		this.operationType = operationType;
	}

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Timestamp getScanDate() {
		return this.scanDate;
	}

	public void setScanDate(Timestamp scanDate) {
		this.scanDate = scanDate;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIsMatch() {
		return this.isMatch;
	}

	public void setIsMatch(Integer isMatch) {
		this.isMatch = isMatch;
	}

	public Integer getOperationType() {
		return this.operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Biduid2scanId))
			return false;
		Biduid2scanId castOther = (Biduid2scanId) other;

		return ((this.getUid() == castOther.getUid()) || (this.getUid() != null
				&& castOther.getUid() != null && this.getUid().equals(
				castOther.getUid())))
				&& ((this.getBid() == castOther.getBid()) || (this.getBid() != null
						&& castOther.getBid() != null && this.getBid().equals(
						castOther.getBid())))
				&& ((this.getScanDate() == castOther.getScanDate()) || (this
						.getScanDate() != null
						&& castOther.getScanDate() != null && this
						.getScanDate().equals(castOther.getScanDate())))
				&& ((this.getX() == castOther.getX()) || (this.getX() != null
						&& castOther.getX() != null && this.getX().equals(
						castOther.getX())))
				&& ((this.getY() == castOther.getY()) || (this.getY() != null
						&& castOther.getY() != null && this.getY().equals(
						castOther.getY())))
				&& ((this.getUsername() == castOther.getUsername()) || (this
						.getUsername() != null
						&& castOther.getUsername() != null && this
						.getUsername().equals(castOther.getUsername())))
				&& ((this.getIsMatch() == castOther.getIsMatch()) || (this
						.getIsMatch() != null && castOther.getIsMatch() != null && this
						.getIsMatch().equals(castOther.getIsMatch())))
				&& ((this.getOperationType() == castOther.getOperationType()) || (this
						.getOperationType() != null
						&& castOther.getOperationType() != null && this
						.getOperationType()
						.equals(castOther.getOperationType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		result = 37 * result
				+ (getBid() == null ? 0 : this.getBid().hashCode());
		result = 37 * result
				+ (getScanDate() == null ? 0 : this.getScanDate().hashCode());
		result = 37 * result + (getX() == null ? 0 : this.getX().hashCode());
		result = 37 * result + (getY() == null ? 0 : this.getY().hashCode());
		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getIsMatch() == null ? 0 : this.getIsMatch().hashCode());
		result = 37
				* result
				+ (getOperationType() == null ? 0 : this.getOperationType()
						.hashCode());
		return result;
	}

}