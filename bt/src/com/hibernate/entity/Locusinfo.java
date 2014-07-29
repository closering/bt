package com.hibernate.entity;

/**
 * Locusinfo entity. @author MyEclipse Persistence Tools
 */

public class Locusinfo implements java.io.Serializable {

	// Fields

	private LocusinfoId id;

	// Constructors

	/** default constructor */
	public Locusinfo() {
	}

	/** full constructor */
	public Locusinfo(LocusinfoId id) {
		this.id = id;
	}

	// Property accessors

	public LocusinfoId getId() {
		return this.id;
	}

	public void setId(LocusinfoId id) {
		this.id = id;
	}

}