package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Bid2uid;

public interface Bid2uidDAO {
	public void add(Bid2uid buid);
	public void delect(Bid2uid buid);
	public List searchBid(String bid);
	public List searchUid(String uid);
	public boolean searchBUid(String bid, String uid);
}
