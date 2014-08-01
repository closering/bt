package com.hibernate.entity;


public class MonitorInfoId implements java.io.Serializable {
	private String userName;
	private String monitorName;
	
	public MonitorInfoId() {
	}

	/** full constructor */
	public MonitorInfoId(String userName, String monitorName) {
		this.userName = userName;
		this.monitorName = monitorName;
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMonitorName() {
		return monitorName;
	}
	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MonitorInfoId))
			return false;
		MonitorInfoId castOther = (MonitorInfoId) other;

		return ((this.getUserName() == castOther.getUserName()) || (this
				.getUserName() != null && castOther.getUserName() != null && this
				.getUserName().equals(castOther.getUserName())))
				&& ((this.getMonitorName() == castOther.getMonitorName()) || (this
						.getMonitorName() != null
						&& castOther.getMonitorName() != null && this
						.getMonitorName().equals(castOther.getMonitorName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result
				+ (getMonitorName() == null ? 0 : this.getMonitorName().hashCode());
		return result;
	}
	
}
