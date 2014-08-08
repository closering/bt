package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.MonitorPosition;

public interface MonitorPositionDAO {
	public void add(MonitorPosition mData);
	public void delete(MonitorPosition mData);
	public List searchByMonitorName(String monitorName);
}
