package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	public static String username="root";

	public static String password="root";

	public static String url="jdbc:mysql://127.0.0.1:3306/offter?useUnicode=true&characterEncoding=utf-8";

	public static String driver="com.mysql.cj.jdbc.Driver";

	static{
		try {
			Class.forName(driver); //加载驱动

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{

		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 关闭数据库连接
	 * @param con
	 */
	public static void close(Connection con,ResultSet rs,Statement st,PreparedStatement ps){
		try {
			if(rs!=null){
				rs.close();
			}

			if(st!=null){
				st.close();
			}

			if(ps!=null){
				ps.close();
			}

			if(con!=null){
				con.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}


	public static void main(String[] args) {

		try {
			getConnection();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}