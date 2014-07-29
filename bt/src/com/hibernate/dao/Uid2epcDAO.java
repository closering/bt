package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Uid2epc;


public interface Uid2epcDAO {
	public void add(Uid2epc uepc);
	public void delect(Uid2epc uepc);
	public List searchByUid(String uid);
	public List searchByEpc(String epc);
	public List searchUidEpc(String uid, String epc);

}
