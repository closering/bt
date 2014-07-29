package com.hibernate.dao;

import java.util.List;

import com.hibernate.entity.Product;

public interface ProductDAO {
	public void add(Product pro);
	public void delete(Product pro);
	public List searchByEpc(String epc);
	public List searchByUsername(String userName);
	public List searchByUsernameEpc(String epc, String userName);

}
