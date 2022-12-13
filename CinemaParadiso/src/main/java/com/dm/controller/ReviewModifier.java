package com.dm.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.crawling.MovieDAO;
import com.dm.crawling.MovieDTO;
import com.dm.paradiso.CommentDAO;
import com.dm.paradiso.CommentDTO;


/**
 * Servlet implementation class ReviewModifier
 */
@WebServlet("/reviewmod.do")
public class ReviewModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewModifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		MovieDAO mDAO=new MovieDAO();
		ArrayList<MovieDTO> miList =new ArrayList<>();
		mDAO.selectPoster(miList);
		CommentDAO cDAO=new CommentDAO();
		CommentDTO cDTO=new CommentDTO();
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
			cDAO.modifyComment(cDTO);
			RequestDispatcher dispatcher=request.getRequestDispatcher("success_c.jsp"); //forwarding
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
