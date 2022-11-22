package com.superstore.operations;

import java.sql.*;
import com.superstore.database.*;

public class Interaction {
	public static boolean addItem(String name,String cat,double price,int quantity)
	{
        boolean task=false;
		try {
			Connection con=DB.makeConnection();
			String q="insert into storage(item_name,item_price,item_quantity,item_cat) VALUES('"+name+"',"+price+","+quantity+",'"+cat+"')";
			Statement st=con.createStatement();
			st.execute(q);
            task=true;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
                return task;
	}
        
	public static int searchItem(String name)
	{
        int id=-1;
		try {
			Connection con=DB.makeConnection();
			String q="select * from storage where item_name='"+name+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			while(rs.next()) {
				id=Integer.parseInt(rs.getString("item_id"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	public static boolean updateItem(String name,String cat,double price,int quantity,int id)
	{
        boolean task=false;
		try {
			Connection con=DB.makeConnection();
			String q="update storage set item_name='"+name+"',item_price="+price+",item_quantity="+quantity+",item_cat='"+cat+"' where item_id="+id+"";
			Statement st=con.createStatement();
			st.execute(q);
                        task=true;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return task;
	}

	public static String[] getItem(int id)
	{
		String s[]=new String[4];
		try {
			Connection con=DB.makeConnection();
			String q="select * from storage where item_id="+id+"";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			while(rs.next()) {
				s[0]=rs.getString("item_name");
				s[1]=rs.getString("item_price");
				s[2]=rs.getString("item_quantity");
				s[3]=rs.getString("item_cat");
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static boolean deleteItem(int id)
	{
	    boolean task=false;
		try {
			Connection con=DB.makeConnection();
			String q="delete from storage where item_id="+id+"";
			Statement st=con.createStatement();
			st.execute(q);
	        task=true;
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return task;
	}
}