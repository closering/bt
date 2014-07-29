package com.hibernate.entity;

/**
 * Username2bid entity. @author MyEclipse Persistence Tools
 */

public class Username2bid implements java.io.Serializable {

	// Fields

	private Username2bidId id;

	// Constructors

	/** default constructor */
	public Username2bid() {
	}

	/** full constructor */
	public Username2bid(Username2bidId id) {
		this.id = id;
	}

	// Property accessors

	public Username2bidId getId() {
		return this.id;
	}

	public void setId(Username2bidId id) {
		this.id = id;
	}

}