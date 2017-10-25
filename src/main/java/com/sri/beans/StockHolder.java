package com.sri.beans;

public class StockHolder 
{

	String Name;
	String Notify;
	
	public StockHolder(String name,String notify) 
	{
		this.Name=name;
		this.Notify=notify;
	}
	public String getNotify() {
		return Notify;
	}

	public void setNotify(String notify) {
		Notify = notify;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
}
