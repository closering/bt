package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Username2bid;


public interface Username2bidDAO {
	public void add(Username2bid uBid);
	public void delete(Username2bid uBid);
	public List searchByBid(String bid);
	public Long searchByUsername(String userName);
}
