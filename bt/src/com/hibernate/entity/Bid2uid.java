package com.hibernate.entity;

/**
 * Bid2uid entity. @author MyEclipse Persistence Tools
 */

public class Bid2uid implements java.io.Serializable {

	// Fields

	private Bid2uidId id;

	// Constructors

	/** default constructor */
	public Bid2uid() {
	}

	/** full constructor */
	public Bid2uid(Bid2uidId id) {
		this.id = id;
	}

	// Property accessors

	public Bid2uidId getId() {
		return this.id;
	}

	public void setId(Bid2uidId id) {
		this.id = id;
	}

}