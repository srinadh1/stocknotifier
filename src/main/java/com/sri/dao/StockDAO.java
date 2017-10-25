package com.sri.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sri.beans.Stock;
import com.sri.java.DatabaseProperties;

public class StockDAO 
{

	private static String  connectionUrl = "";
	private static Properties dbprops = null;
	static ArrayList<Stock> stocks=new ArrayList<Stock>();
	
	static
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("");
		dbprops = DatabaseProperties.getInstance().getProperties();
		connectionUrl = "jdbc:mysql://" 
			+ dbprops.getProperty("server") 
			+ ":" + dbprops.getProperty("port")
			+ "/" + dbprops.getProperty("database")+"?autoReconnect=true&useSSL=false";
		}
		catch(Exception e) 
		{
		e.printStackTrace();
		}
}

{
	System.out.println("Called when the class is initialized");
}

public static Connection getConnection() throws Exception
{
	Connection con = DriverManager.getConnection(connectionUrl, dbprops.getProperty("userid"), dbprops.getProperty("password"));
	return con;
}

public static ArrayList<Stock> select() {
	
	Connection con = null;

	try 
	{
		con = getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from stock");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) 
		{
		Stock stock=new Stock(rs.getString("stockticker"),rs.getInt("price"),rs.getString("notified"));
		stocks.add(stock);
		}
			
	} 
	catch (Exception e) 
	{
		System.out.println(e);
	}
	finally
	{
		if(con != null)
		{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		}
	}
	return stocks;
}	
}