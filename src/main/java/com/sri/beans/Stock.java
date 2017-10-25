package com.sri.beans;

public class Stock {
String stockticker;
int price;
String notified;

public Stock(String s1,int i,String s2)
{
	this.stockticker=s1;
	this.price=i;
	this.notified=s2;
}
public String getStockticker() 
{
	return stockticker;
}
public void setStockticker(String stockticker) 
{
	this.stockticker = stockticker;
}
public int getPrice()
{
	return price;
}
public void setPrice(int price)
{
	this.price = price;
}
public String getNotified()
{
	return notified;
}
public void setNotified(String notified)
{
	this.notified = notified;
}
}
