package com.ca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataConner {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String dbName = "CA";
	private static String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";
	private static String userName = "root";
	private static String pwd = "123";
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, pwd);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pst, Connection conn) {
		close(null, pst, conn);
	}
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String dbName = "CA";
//		String path = "jdbc:mysql://localhost:3306/" + dbName;
//		String userName = "root";
//		String pwd = "123";
//		conn = DriverManager.getConnection(path, userName, pwd);
//		
//		pstmt = conn.prepareStatement("select * from t_member");
//		rs = pstmt.executeQuery();
//		while(rs.next()) {
//			
//			System.out.println(rs.getString("m_name") + " " + rs.getString(2));
//		}
//		
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//		try {
//			rs.close();
//			pstmt.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//	
//}
}
