package com.baseData;

import java.sql.Timestamp;

public class locusData {
	double x;
	double y;
	String add;
	String userName;
	Timestamp serverDate;
	
	public locusData()
	{	}

	public locusData(double x,	double y,	String add,	String userName,	Timestamp serverDate)
	{
		this.x = x;
		this.y = y;
		this.add = add;
		this.userName = userName;
		this.serverDate = serverDate;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getServerDate() {
		return serverDate;
	}

	public void setServerDate(Timestamp serverDate) {
		this.serverDate = serverDate;
	}
}
