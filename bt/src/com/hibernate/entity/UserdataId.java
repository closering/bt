package com.hibernate.entity;

import java.util.Date;

/**
 * UserdataId entity. @author MyEclipse Persistence Tools
 */

public class UserdataId implements java.io.Serializable {

	// Fields

	private String userName;
	private String password;
	private String email;
	private Integer type;
	private String name;
	private Double x;
	private Double y;
	private Integer radius;
	private String address;
	private Date establishDate;
	private String postcode;
	private String contactPerson;
	private String phone;

	// Constructors

	/** default constructor */
	public UserdataId() {
	}

	/** full constructor */
	public UserdataId(String userName, String password, String email,
			Integer type, String name, Double x, Double y, Integer radius,
			String address, Date establishDate, String postcode,
			String contactPerson, String phone) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.type = type;
		this.name = name;
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.address = address;
		this.establishDate = establishDate;
		this.postcode = postcode;
		this.contactPerson = contactPerson;
		this.phone = phone;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Integer getRadius() {
		return this.radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEstablishDate() {
		return this.establishDate;
	}

	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserdataId))
			return false;
		UserdataId castOther = (UserdataId) other;

		return ((this.getUserName() == castOther.getUserName()) || (this
				.getUserName() != null && castOther.getUserName() != null && this
				.getUserName().equals(castOther.getUserName())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getX() == castOther.getX()) || (this.getX() != null
						&& castOther.getX() != null && this.getX().equals(
						castOther.getX())))
				&& ((this.getY() == castOther.getY()) || (this.getY() != null
						&& castOther.getY() != null && this.getY().equals(
						castOther.getY())))
				&& ((this.getRadius() == castOther.getRadius()) || (this
						.getRadius() != null && castOther.getRadius() != null && this
						.getRadius().equals(castOther.getRadius())))
				&& ((this.getAddress() == castOther.getAddress()) || (this
						.getAddress() != null && castOther.getAddress() != null && this
						.getAddress().equals(castOther.getAddress())))
				&& ((this.getEstablishDate() == castOther.getEstablishDate()) || (this
						.getEstablishDate() != null
						&& castOther.getEstablishDate() != null && this
						.getEstablishDate()
						.equals(castOther.getEstablishDate())))
				&& ((this.getPostcode() == castOther.getPostcode()) || (this
						.getPostcode() != null
						&& castOther.getPostcode() != null && this
						.getPostcode().equals(castOther.getPostcode())))
				&& ((this.getContactPerson() == castOther.getContactPerson()) || (this
						.getContactPerson() != null
						&& castOther.getContactPerson() != null && this
						.getContactPerson()
						.equals(castOther.getContactPerson())))
				&& ((this.getPhone() == castOther.getPhone()) || (this
						.getPhone() != null && castOther.getPhone() != null && this
						.getPhone().equals(castOther.getPhone())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getX() == null ? 0 : this.getX().hashCode());
		result = 37 * result + (getY() == null ? 0 : this.getY().hashCode());
		result = 37 * result
				+ (getRadius() == null ? 0 : this.getRadius().hashCode());
		result = 37 * result
				+ (getAddress() == null ? 0 : this.getAddress().hashCode());
		result = 37
				* result
				+ (getEstablishDate() == null ? 0 : this.getEstablishDate()
						.hashCode());
		result = 37 * result
				+ (getPostcode() == null ? 0 : this.getPostcode().hashCode());
		result = 37
				* result
				+ (getContactPerson() == null ? 0 : this.getContactPerson()
						.hashCode());
		result = 37 * result
				+ (getPhone() == null ? 0 : this.getPhone().hashCode());
		return result;
	}

}