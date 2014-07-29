package com.hibernate.root;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.dao.Bid2uidDAO;
import com.hibernate.dao.LocusinfoDAO;
import com.hibernate.dao.ProductDAO;
import com.hibernate.dao.Uid2epcDAO;
import com.hibernate.dao.UserdataDAO;
import com.hibernate.entity.Bid2uid;
import com.hibernate.entity.Bid2uidId;
import com.hibernate.entity.Locusinfo;
import com.hibernate.entity.Product;
import com.hibernate.entity.ProductId;
import com.hibernate.entity.Uid2epc;
import com.hibernate.entity.Uid2epcId;
import com.hibernate.entity.Userdata;
import com.hibernate.entity.UserdataId;
import com.hibernate.impl.Bid2uidDAOImpl;
import com.hibernate.impl.LocusinfoDAOImpl;
import com.hibernate.impl.UserdataDAOImpl;

public class test {
	public static void main(String[] args)
	{
//		Bid2uid buid = new Bid2uid();
//		Bid2uidId buidId = new Bid2uidId();
//		
//		buidId.setBid("11");
//		buidId.setUid("21");
//		
//		buid.setId(buidId);
//		
//		Bid2uidDAO bidDao = new Bid2uidDAOImpl();
//		
//		//bidDao.add(buid);		
//		bidDao.delect(buid);
		
		
		
		
		
//		Uid2epc uepc = new Uid2epc();
//		Uid2epcId uepcId = new Uid2epcId();
//		
//		uepcId.setEpc("11");
//		uepcId.setUid("22");
//		
//		uepc.setId(uepcId);
//		
//		Uid2epcDAO uepcDao = new Uid2epcDAOImpl();
//		uepcDao.add(uepc);
//		//uepcDao.delect(uepc);
//		System.out.println(uepcDao.searchBUid("22", "11"));
		
		
//		ProductId pId = new ProductId();
//		Product p = new Product();
//		
//		pId.setEpc("gjireoa");
//		p.setId(pId);
		
//		ProductDAO pDao = new ProductDAOImpl();
//		System.out.println(pDao.searchByPID("grni"));
		
		LocusinfoDAO liDao = new LocusinfoDAOImpl();
		
		List list = liDao.searchByUsernameID("aa", new Long(1));
		
		System.out.print(((Locusinfo)list.get(0)).getId().getUsername());
		
		
		
		
		
		
	}
}
