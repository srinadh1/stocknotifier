package com.sri.java;

import java.util.ArrayList;

import com.sri.beans.Stock;
import com.sri.beans.StockHolder;
import com.sri.dao.CustomerDAO;
import com.sri.dao.StockDAO;

public class StockObserver extends Thread
{
	ArrayList<Stock> stocks=new ArrayList<Stock>();	
	ArrayList<StockHolder> stockholders=new ArrayList<StockHolder>();
	
	public void run() 
	{
		stockholders=CustomerDAO.select();
		while(true)
		{
		notifyStocks();
		
		try
		{
			Thread.sleep(10000);
		 }
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
		
	}
}
public void notifyStocks() 
	{
		stocks=StockDAO.select();
		for(StockHolder sh:stockholders) 
		{
			
		for(int i=0;i<stocks.size();i++)
		{
			if(stocks.get(i).getNotified().equalsIgnoreCase("no")&&stocks.get(i).getPrice()>100) 
			{
			
			System.out.println(sh.getName()+" "+"Stock Name:"+stocks.get(i).getStockticker()+" Stock Price:"+stocks.get(i).getPrice());
			}
		}
		}
	}
	
}