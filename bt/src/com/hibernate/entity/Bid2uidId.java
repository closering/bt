package com.hibernate.entity;

/**
 * Bid2uidId entity. @author MyEclipse Persistence Tools
 */

public class Bid2uidId implements java.io.Serializable {

	// Fields

	private String bid;
	private String uid;

	// Constructors

	/** default constructor */
	public Bid2uidId() {
	}

	/** full constructor */
	public Bid2uidId(String bid, String uid) {
		this.bid = bid;
		this.uid = uid;
	}

	// Property accessors

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Bid2uidId))
			return false;
		Bid2uidId castOther = (Bid2uidId) other;

		return ((this.getBid() == castOther.getBid()) || (this.getBid() != null
				&& castOther.getBid() != null && this.getBid().equals(
				castOther.getBid())))
				&& ((this.getUid() == castOther.getUid()) || (this.getUid() != null
						&& castOther.getUid() != null && this.getUid().equals(
						castOther.getUid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBid() == null ? 0 : this.getBid().hashCode());
		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		return result;
	}

}