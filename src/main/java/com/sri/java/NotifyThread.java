package com.sri.java;

import java.util.ArrayList;

public class NotifyThread {

	public static void main(String[] args) 
	{
		Thread t1=new StockObserver();
			t1.start();
		
		
	}
}
