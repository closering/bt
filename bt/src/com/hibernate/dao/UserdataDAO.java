package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Userdata;

public interface UserdataDAO {
	public void add(Userdata uData);
	public void delete(Userdata uData);
	public boolean searchByNamePassword(String name, String password);
	public List searchByName(String name);

}
