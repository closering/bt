package com.hibernate.entity;

/**
 * Userdata entity. @author MyEclipse Persistence Tools
 */

public class Userdata implements java.io.Serializable {

	// Fields

	private UserdataId id;

	// Constructors

	/** default constructor */
	public Userdata() {
	}

	/** full constructor */
	public Userdata(UserdataId id) {
		this.id = id;
	}

	// Property accessors

	public UserdataId getId() {
		return this.id;
	}

	public void setId(UserdataId id) {
		this.id = id;
	}

}