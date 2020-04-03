package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtil {
	public Connection getConnection(String name) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/work?user=root&password=123456&useSSL=false&useUnicode=true&characterEncoding=UTF-8");
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	public String[] find(String work,String user,String ID) {
		try {
			String sql="select * from "+user+" where ID="+ID;
			Connection con=getConnection(work);
			Statement sta=con.createStatement();
			ResultSet res=sta.executeQuery(sql);
			String[] str=new String[2];
			res.next();
			str[0]=res.getString(1);
			str[1]=res.getString(2);
			res.close();
			sta.close();
			con.close();
			return str;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查找所有用户信息
	public ArrayList<String[]> findAllUsers(String work) {
		try {
			ArrayList<String[]> arr=new ArrayList<String[]>();
			String sql="select * from user";
			Connection con=getConnection(work);
			Statement sta=con.createStatement();
			ResultSet res=sta.executeQuery(sql);
			while(res.next()) {
				String[] str=new String[2];
				str[0]=res.getString(1);
				str[1]=res.getString(2);
				arr.add(str);
			}
			res.close();
			sta.close();
			con.close();
			return arr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查找所有商品信息
	public ArrayList<String[]> findAllGoods(String work) {
		try {
			ArrayList<String[]> arr=new ArrayList<String[]>();
			String sql="select * from goods";
			Connection con=getConnection(work);
			Statement sta=con.createStatement();
			ResultSet res=sta.executeQuery(sql);
			while(res.next()) {
				String[] str=new String[8];
				str[0]=res.getString(1);
				str[1]=res.getString(2);
				str[2]=res.getString(3);
				str[3]=res.getString(4);
				str[4]=res.getString(5);
				str[5]=res.getString(6);
				str[6]=res.getString(7);
				str[7]=res.getString(8);
				arr.add(str);
			}
			res.close();
			sta.close();
			con.close();
			return arr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
