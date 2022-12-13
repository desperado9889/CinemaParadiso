package com.dm.crawling;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.paradiso.CommentDAO;
import com.dm.paradiso.CommentDTO;

/**
 * Servlet implementation class Rating
 */
@WebServlet("/Rating.do")
public class Rating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rating() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		ArrayList<MovieDTO> miList =(ArrayList<MovieDTO>) session.getAttribute("miList");
		CommentDTO cDTO = new CommentDTO();
		CommentDAO cDAO = new CommentDAO();
		
		String loginCheck = (String) session.getAttribute("user_login");
		if(loginCheck!=null) {
			String id = (String)session.getAttribute("user_id");
			String rating_s = request.getParameter("rating");
			int rating = Integer.parseInt(rating_s);
			String comment = request.getParameter("comment");
			cDTO.setId(id);
			cDTO.setRating(rating);
			cDTO.setComment(comment);
			for(int i=0; i<miList.size() ;i++) {
				MovieDTO movielist = miList.get(i);
				String movie_code=movielist.getMovie_code();
				cDTO.setMovie_code(movie_code);
			}
			
			System.out.println(cDTO.getId());
			System.out.println(cDTO.getRating());
			System.out.println(cDTO.getComment());
			System.out.println(cDTO.getMovie_code());
			try {
				cDAO.insertComment(cDTO);
				RequestDispatcher dispatcher=request.getRequestDispatcher("/infoSelect.do"); //원하는 뷰 선택해서 포워딩
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("error_c.jsp"); //원하는 뷰 선택해서 포워딩
			dispatcher.forward(request, response);
		}
	}
}
