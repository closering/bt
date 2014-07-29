package com.hibernate.entity;

/**
 * Username2bidId entity. @author MyEclipse Persistence Tools
 */

public class Username2bidId implements java.io.Serializable {

	// Fields

	private String username;
	private Long id;
	private String bid;

	// Constructors

	/** default constructor */
	public Username2bidId() {
	}

	/** full constructor */
	public Username2bidId(String username, Long id, String bid) {
		this.username = username;
		this.id = id;
		this.bid = bid;
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

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Username2bidId))
			return false;
		Username2bidId castOther = (Username2bidId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getBid() == castOther.getBid()) || (this.getBid() != null
						&& castOther.getBid() != null && this.getBid().equals(
						castOther.getBid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getBid() == null ? 0 : this.getBid().hashCode());
		return result;
	}

}