package com.hibernate.entity;

import java.sql.Timestamp;

public class MonitorPositionId implements java.io.Serializable{
	private String monitorName;
	private Double longitude;
	private Double latitude;
	private Timestamp time;
	
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MonitorPositionId))
			return false;
		MonitorPositionId castOther = (MonitorPositionId) other;

		return ((this.getMonitorName() == castOther.getMonitorName()) || (this
						.getMonitorName() != null
						&& castOther.getMonitorName() != null && this
						.getMonitorName().equals(castOther.getMonitorName())))
			   && ((this.getLongitude() == castOther.getLongitude()) || (this.getLongitude() != null
						&& castOther.getLongitude() != null && this.getLongitude().equals(
						castOther.getLongitude())))
			   && ((this.getLatitude() == castOther.getLatitude()) || (this.getLatitude() != null
						&& castOther.getLatitude() != null && this.getLatitude().equals(
						castOther.getLatitude())))
			   && ((this.getTime() == castOther.getTime()) || (this
						.getTime() != null
						&& castOther.getTime() != null && this
						.getTime()
						.equals(castOther.getTime())))
				;
		
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMonitorName() == null ? 0 : this.getMonitorName().hashCode());
		result = 37 * result
				+ (getLongitude() == null ? 0 : this.getLongitude().hashCode());
		result = 37 * result
				+ (getLatitude() == null ? 0 : this.getLatitude().hashCode());
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		return result;
	}
}
