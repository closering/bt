package com.hibernate.entity;

import java.util.Date;

/**
 * Uid2epcId entity. @author MyEclipse Persistence Tools
 */

public class Uid2epcId implements java.io.Serializable {

	// Fields

	private String uid;
	private String epc;
	private Integer recall;
	private Integer isExpire;
	private Date producedate;

	// Constructors

	/** default constructor */
	public Uid2epcId() {
	}

	/** full constructor */
	public Uid2epcId(String uid, String epc, Integer recall, Integer isExpire,
			Date producedate) {
		this.uid = uid;
		this.epc = epc;
		this.recall = recall;
		this.isExpire = isExpire;
		this.producedate = producedate;
	}

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEpc() {
		return this.epc;
	}

	public void setEpc(String epc) {
		this.epc = epc;
	}

	public Integer getRecall() {
		return this.recall;
	}

	public void setRecall(Integer recall) {
		this.recall = recall;
	}

	public Integer getIsExpire() {
		return this.isExpire;
	}

	public void setIsExpire(Integer isExpire) {
		this.isExpire = isExpire;
	}

	public Date getProducedate() {
		return this.producedate;
	}

	public void setProducedate(Date producedate) {
		this.producedate = producedate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Uid2epcId))
			return false;
		Uid2epcId castOther = (Uid2epcId) other;

		return ((this.getUid() == castOther.getUid()) || (this.getUid() != null
				&& castOther.getUid() != null && this.getUid().equals(
				castOther.getUid())))
				&& ((this.getEpc() == castOther.getEpc()) || (this.getEpc() != null
						&& castOther.getEpc() != null && this.getEpc().equals(
						castOther.getEpc())))
				&& ((this.getRecall() == castOther.getRecall()) || (this
						.getRecall() != null && castOther.getRecall() != null && this
						.getRecall().equals(castOther.getRecall())))
				&& ((this.getIsExpire() == castOther.getIsExpire()) || (this
						.getIsExpire() != null
						&& castOther.getIsExpire() != null && this
						.getIsExpire().equals(castOther.getIsExpire())))
				&& ((this.getProducedate() == castOther.getProducedate()) || (this
						.getProducedate() != null
						&& castOther.getProducedate() != null && this
						.getProducedate().equals(castOther.getProducedate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		result = 37 * result
				+ (getEpc() == null ? 0 : this.getEpc().hashCode());
		result = 37 * result
				+ (getRecall() == null ? 0 : this.getRecall().hashCode());
		result = 37 * result
				+ (getIsExpire() == null ? 0 : this.getIsExpire().hashCode());
		result = 37
				* result
				+ (getProducedate() == null ? 0 : this.getProducedate()
						.hashCode());
		return result;
	}

}