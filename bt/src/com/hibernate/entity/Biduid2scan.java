package com.hibernate.entity;

/**
 * Biduid2scan entity. @author MyEclipse Persistence Tools
 */

public class Biduid2scan implements java.io.Serializable {

	// Fields

	private Biduid2scanId id;

	// Constructors

	/** default constructor */
	public Biduid2scan() {
	}

	/** full constructor */
	public Biduid2scan(Biduid2scanId id) {
		this.id = id;
	}

	// Property accessors

	public Biduid2scanId getId() {
		return this.id;
	}

	public void setId(Biduid2scanId id) {
		this.id = id;
	}

}