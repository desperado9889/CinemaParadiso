package com.dm.paradiso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegisterDAO {
	final String USER_INSERT="insert into cp_account values(?, ?, ?, ?);";
	final String USER_LIST="select * from cp_account;";
	final String USER_SELECT="select * from cp_account where id=?;";
	final String USER_LOGIN="select * from cp_account where id=? and password=?;";
	final String USER_MODIFY="update cp_account set password=? name=? date=? where id=?";
	final String USER_DELETE="delete from cp_account where id=?";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public void insertMember(RegisterDTO mem) throws SQLException {	//실행하려는 쿼리마다 메소드 단위로 작성 가능
		try{
			conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			pstmt=conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getDate());
			pstmt.executeUpdate();
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}

	public String loginCheck(String id, String password) {
		String name=null;
		try {
	    	conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			pstmt=conn.prepareStatement(USER_LOGIN);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			
	    } finally {
	    	JDBCutil.close(pstmt,conn);
	    }
		return name;
	}
	
	public ArrayList<RegisterDTO> selectMemberList() throws SQLException {	//실행하려는 쿼리마다 메소드 단위로 작성 가능
		
		ArrayList<RegisterDTO> aList = new ArrayList<RegisterDTO>();	// "<>": 제네릭 즉 타입이 들어갈 위치
		try{
			conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			pstmt=conn.prepareStatement(USER_LIST);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				RegisterDTO rd=new RegisterDTO();
				rd.setId(rs.getString("id"));
				rd.setPassword(rs.getString("password"));
				rd.setName(rs.getString("name"));
				rd.setDate(rs.getString("date"));
				aList.add(rd);
			}
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		
		return aList;
	}
	
	public ArrayList<RegisterDTO> selectUser(String id) throws SQLException {	//실행하려는 쿼리마다 메소드 단위로 작성 가능
		
		ArrayList<RegisterDTO> aList = new ArrayList<RegisterDTO>();	// "<>": 제네릭 즉 타입이 들어갈 위치
		try{
			conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			pstmt=conn.prepareStatement(USER_SELECT);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				RegisterDTO rd=new RegisterDTO();
				rd.setId(rs.getString("id"));
				rd.setPassword(rs.getString("password"));
				rd.setName(rs.getString("name"));
				rd.setDate(rs.getString("date"));
				aList.add(rd);
			}
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		
		return aList;
	}
	
	public void modifyUser(RegisterDTO mem) throws SQLException{
		try {
			conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			pstmt=conn.prepareStatement(USER_MODIFY);
			pstmt.setString(1, mem.getPassword());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getDate());
			pstmt.setString(4, mem.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}
	
	public void deleteUser(String id) throws SQLException{
		try {
			conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			pstmt=conn.prepareStatement(USER_DELETE);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}
	
}
