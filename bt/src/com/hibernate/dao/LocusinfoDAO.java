package com.hibernate.dao;

import java.math.BigInteger;
import java.util.List;

import com.hibernate.entity.Locusinfo;


public interface LocusinfoDAO {
	public void add(Locusinfo locus);
	public void delete(Locusinfo locus);
	public List searchByUsernameID(String userName, Long ID);

}
