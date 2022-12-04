package com.dm.paradiso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCutil {
	final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	final static String JDBC_URL="jdbc:mysql://localhost:3306/cinemaparadiso?serverTimezone=UTC&useSSL=false&useUnicode=true&characterEncoding=utf-8"; //DB서버/DB명
	final static String JDBC_USER="root"; //계정
	final static String JDBC_PASS="3220"; //비번
	
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
	public static void close(PreparedStatement pstmt, Connection conn) {	//update등의 쿼리 실행 시
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs,PreparedStatement pstmt, Connection conn) {	//셀렉트 쿼리 실행할 경우
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
