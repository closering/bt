package com.hibernate.entity;

/**
 * Uid2epc entity. @author MyEclipse Persistence Tools
 */

public class Uid2epc implements java.io.Serializable {

	// Fields

	private Uid2epcId id;

	// Constructors

	/** default constructor */
	public Uid2epc() {
	}

	/** full constructor */
	public Uid2epc(Uid2epcId id) {
		this.id = id;
	}

	// Property accessors

	public Uid2epcId getId() {
		return this.id;
	}

	public void setId(Uid2epcId id) {
		this.id = id;
	}

}