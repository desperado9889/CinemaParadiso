package com.dm.paradiso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO {
	final String COMMENT_INSERT="insert into comment_table values(?, ?, ?, ?);";
	final String COMMENT_SELECT="select * from comment_table";
	final String COMMENT_SELECT_USER="select * from comment_table where id=?";
	final String COMMENT_UPDATE="update comment_table set comment=?, rating=? where id=? and movie_code=?";
	final String COMMENT_RATING_AVERAGE="select avg(rating) from comment_table ";
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public void insertComment(CommentDTO mem) throws SQLException {	
		try{
			conn = JDBCutil.getConnection(); 
			pstmt=conn.prepareStatement(COMMENT_INSERT);
			pstmt.setString(1, mem.getId());
			pstmt.setInt(2, mem.getRating());
			pstmt.setString(3, mem.getComment());
			pstmt.setString(4, mem.getMovie_code());
			pstmt.executeUpdate();
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		System.out.println("comment insert");
	}
	public ArrayList<CommentDTO> selectComment() throws SQLException {	
		
		ArrayList<CommentDTO> cList = new ArrayList<CommentDTO>();	
		try{
			conn = JDBCutil.getConnection(); 
			pstmt=conn.prepareStatement(COMMENT_SELECT);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				CommentDTO rd=new CommentDTO();
				rd.setId(rs.getString("id"));
				rd.setRating(rs.getInt("rating"));
				rd.setComment(rs.getString("comment"));
				rd.setMovie_code(rs.getString("movie_code"));
				cList.add(rd);
			}
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		
		return cList;
	}
	public ArrayList<CommentDTO> selectComment_user(String id) throws SQLException{
		ArrayList<CommentDTO> cuList = new ArrayList<CommentDTO>();
		try {
			conn = JDBCutil.getConnection();
			pstmt=conn.prepareStatement(COMMENT_SELECT_USER);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO rd=new CommentDTO();
				rd.setId(rs.getString("id"));
				rd.setRating(rs.getInt("rating"));
				rd.setComment(rs.getString("comment"));
				rd.setMovie_code(rs.getString("movie_code"));
				cuList.add(rd);
			}
		}catch(Exception e){
			
		}finally{
			JDBCutil.close(pstmt,conn);
		}
		
		return cuList;
	}
	
	public void modifyComment(CommentDTO mem)throws SQLException{
		try{
			conn = JDBCutil.getConnection(); 
			pstmt=conn.prepareStatement(COMMENT_UPDATE);
			pstmt.setString(1, mem.getComment());
			pstmt.setInt(2, mem.getRating());
			pstmt.setString(3, mem.getId());
			pstmt.setString(4, mem.getMovie_code());
			pstmt.executeUpdate();
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}
	
	public double rating_average()throws SQLException{
		double avg=0;
		try{
			conn = JDBCutil.getConnection(); 
			pstmt=conn.prepareStatement(COMMENT_RATING_AVERAGE);
			rs=pstmt.executeQuery();
			avg=rs.getDouble("avg(rating)");
			System.out.println(avg);
		} catch(Exception e){
			
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		return avg;
	}
	
}
