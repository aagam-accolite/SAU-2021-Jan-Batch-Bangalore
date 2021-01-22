package com.au.generation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Task  {
	
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException 
	{
		
		/* Random No Generation and File IO */
		FileOutputStream out = null;
		FileInputStream input = null;
		Random rand = new Random();
		try {
			out = new FileOutputStream("output.txt");
			int randomNum = rand.nextInt(100);
			while(randomNum % 5 != 0 && randomNum !=0)  
			{
				out.write(randomNum);
				randomNum = rand.nextInt(100);
			}
			out.write(randomNum);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		out.close();
		ArrayList<Integer> outputlst = new ArrayList<Integer>();
		try {
			input = new FileInputStream("output.txt");
			int no;
			while ((no = input.read()) != -1) {
					outputlst.add(no);
				}
			System.out.println(outputlst);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		input.close();
		
		
		/* Stream Operation*/
		Integer res = outputlst.stream().filter(e-> e%5 == 0).map(e-> e*2).reduce(1,(a,b)->{return a*b;});
		System.out.println(res);
		
		/* JDBC Connection */
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";		
		String username = "sMkXvyYxZM";
		String	passowrd = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url, username, passowrd);
		String sql = "insert into test values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, res);
		preparedStatement.setString(2,"Aagam");
		preparedStatement.execute();

		ResultSet result = preparedStatement.executeQuery("select * from test");
		System.out.println("Id" + "   " + "Name" );
		while(result.next()) {
		    String id = result.getString("id");
		    String name = result.getString("name");
		    System.out.println(id + "   " + name); 
		}
	}
}
