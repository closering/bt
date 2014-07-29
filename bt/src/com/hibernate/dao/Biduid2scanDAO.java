package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Biduid2scan;

public interface Biduid2scanDAO {
	public void add(Biduid2scan bus);
	public void delect(Biduid2scan bus);
	public List searchByBidUid(String Bid, String Uid);
	public List searchByBidUid(String Bid, String Uid, Integer isMatch);
	public List searchByUid(String uid, Integer isMatch);
	public List searchByBid(String bid, Integer isMatch);
}
