package com.dm.crawling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dm.paradiso.JDBCutil;
import com.dm.paradiso.RegisterDTO;

public class MovieDAO {
	final String POSTER_INSERT="insert into movie_table values (?, ?, ?, ?)";
	final String POSTER_LIST="select * from movie_table;";
	final String USER_UPDATE="update movie_table set password=?, name=?, date=? where id=?";
	final String MOVIE_INSERT="insert into movie_info values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	final String MOVIE_SELECT="select * from movie_info";
	final String MOVIE_SELECT_TITLE="select title from movie_info where movie_code=?";
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public void insertPoster(ArrayList<MovieDTO> mList) throws SQLException {	//실행하려는 쿼리마다 메소드 단위로 작성 가능
		try{
			conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
			for(int i=0; i<mList.size(); i++) {
				pstmt=conn.prepareStatement(POSTER_INSERT);
				pstmt.setString(1, mList.get(i).getRank());
				pstmt.setString(2, mList.get(i).getTitle());
				pstmt.setString(3, mList.get(i).getPoster());
				pstmt.setString(4, mList.get(i).getMovie_code());
				pstmt.executeUpdate();
			}
			System.out.println("upload complete");
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}
	
	public void selectPoster(ArrayList<MovieDTO> mList){
		conn = JDBCutil.getConnection(); //static 메소드를 쓰려면 클래스이름.메소드()
		try {
			pstmt=conn.prepareStatement(POSTER_LIST);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String rank=rs.getString("rank");
				String title=rs.getString("title");
				String poster=rs.getString("poster");
				String movie_code=rs.getString("movie_code");
				mList.add(new MovieDTO(rank, title, poster, movie_code));
			}
			System.out.println("select complete");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}
	public void insertInfo(ArrayList<MovieDTO> miList) throws SQLException{
		try {
			conn = JDBCutil.getConnection();
			for(int i=0; i<miList.size(); i++) {
				pstmt=conn.prepareStatement(MOVIE_INSERT);
				pstmt.setString(1, miList.get(i).getTitle());
				pstmt.setString(2, miList.get(i).getPoster());
				pstmt.setString(3, miList.get(i).getAudience());
				pstmt.setInt(4, miList.get(i).getPg());
				pstmt.setInt(5, miList.get(i).getRunning_time());
				pstmt.setString(6, miList.get(i).getDate());
				pstmt.setString(7, miList.get(i).getDirector());
				pstmt.setString(8, miList.get(i).getCast());
				pstmt.setString(9, miList.get(i).getSynopsis());
				pstmt.setString(10, miList.get(i).getMovie_code());
				pstmt.setString(11, miList.get(i).getStillcut());
				pstmt.setString(12, miList.get(i).getGenre());
				pstmt.executeUpdate();
			}
			System.out.println("info upload complete");	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCutil.close(pstmt,conn);
		}
	}
	public void selectInfo(ArrayList<MovieDTO> miList) throws SQLException{
		try {
			conn = JDBCutil.getConnection(); 
			pstmt=conn.prepareStatement(MOVIE_SELECT);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String poster=rs.getString("poster");
				String audience=rs.getString("count");
				int pg=rs.getInt("pg");
				int running_time=rs.getInt("running_time");
				String date=rs.getString("onscreen");
				String director=rs.getString("director");
				String cast=rs.getString("cast");
				String synopsis=rs.getString("synopsis");
				String movie_code=rs.getString("movie_code");
				String stillcut=rs.getString("stillcut");
				String genre=rs.getString("genre");
				miList.add(new MovieDTO(title, poster, audience, pg, running_time, date, director, cast, synopsis, movie_code, stillcut, genre));
			} 
			System.out.println("select complete");
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		
	}
	
	public ArrayList<MovieDTO> selectTitle(String movie_code)throws SQLException{
		ArrayList<MovieDTO> mcList = new ArrayList<MovieDTO>();
		try {
			conn = JDBCutil.getConnection(); 
			pstmt=conn.prepareStatement(MOVIE_SELECT_TITLE);
			pstmt.setString(1, movie_code);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MovieDTO rd=new MovieDTO();
				rd.setTitle(rs.getString("title"));
				rd.setMovie_code(rs.getString("movie_code"));
				mcList.add(rd);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCutil.close(pstmt,conn);
		}
		return mcList;
	}

}