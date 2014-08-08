package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.MonitorInfo;

public interface MonitorInfoDAO {
	public void add(MonitorInfo mData);
	public void delete(MonitorInfo mData);
	public List searchByUsername(String username);
	public List searchByMonitorName(String monitorName);
	public List searchByUsernameAndMonitorName(String username, String monitorName);
	public void update(MonitorInfo mData);
}
