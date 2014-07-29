package com.hibernate.entity;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private ProductId id;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** full constructor */
	public Product(ProductId id) {
		this.id = id;
	}

	// Property accessors

	public ProductId getId() {
		return this.id;
	}

	public void setId(ProductId id) {
		this.id = id;
	}

}