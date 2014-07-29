package com.hibernate.entity;

import java.util.Date;

/**
 * ProductId entity. @author MyEclipse Persistence Tools
 */

public class ProductId implements java.io.Serializable {

	// Fields

	private String epc;
	private String userName;
	private Integer expireDays;
	private Date productTime;
	private String category;
	private String productName;

	// Constructors

	/** default constructor */
	public ProductId() {
	}

	/** full constructor */
	public ProductId(String epc, String userName, Integer expireDays,
			Date productTime, String category, String productName) {
		this.epc = epc;
		this.userName = userName;
		this.expireDays = expireDays;
		this.productTime = productTime;
		this.category = category;
		this.productName = productName;
	}

	// Property accessors

	public String getEpc() {
		return this.epc;
	}

	public void setEpc(String epc) {
		this.epc = epc;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getExpireDays() {
		return this.expireDays;
	}

	public void setExpireDays(Integer expireDays) {
		this.expireDays = expireDays;
	}

	public Date getProductTime() {
		return this.productTime;
	}

	public void setProductTime(Date productTime) {
		this.productTime = productTime;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProductId))
			return false;
		ProductId castOther = (ProductId) other;

		return ((this.getEpc() == castOther.getEpc()) || (this.getEpc() != null
				&& castOther.getEpc() != null && this.getEpc().equals(
				castOther.getEpc())))
				&& ((this.getUserName() == castOther.getUserName()) || (this
						.getUserName() != null
						&& castOther.getUserName() != null && this
						.getUserName().equals(castOther.getUserName())))
				&& ((this.getExpireDays() == castOther.getExpireDays()) || (this
						.getExpireDays() != null
						&& castOther.getExpireDays() != null && this
						.getExpireDays().equals(castOther.getExpireDays())))
				&& ((this.getProductTime() == castOther.getProductTime()) || (this
						.getProductTime() != null
						&& castOther.getProductTime() != null && this
						.getProductTime().equals(castOther.getProductTime())))
				&& ((this.getCategory() == castOther.getCategory()) || (this
						.getCategory() != null
						&& castOther.getCategory() != null && this
						.getCategory().equals(castOther.getCategory())))
				&& ((this.getProductName() == castOther.getProductName()) || (this
						.getProductName() != null
						&& castOther.getProductName() != null && this
						.getProductName().equals(castOther.getProductName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEpc() == null ? 0 : this.getEpc().hashCode());
		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37
				* result
				+ (getExpireDays() == null ? 0 : this.getExpireDays()
						.hashCode());
		result = 37
				* result
				+ (getProductTime() == null ? 0 : this.getProductTime()
						.hashCode());
		result = 37 * result
				+ (getCategory() == null ? 0 : this.getCategory().hashCode());
		result = 37
				* result
				+ (getProductName() == null ? 0 : this.getProductName()
						.hashCode());
		return result;
	}

}