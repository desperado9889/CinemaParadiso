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
import com.dm.paradiso.RegisterDAO;
import com.dm.paradiso.RegisterDTO;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPage.do")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO mdao=new MovieDAO();
		CommentDAO cdao=new CommentDAO();
		RegisterDAO rdao=new RegisterDAO();
		MovieDTO tList= new MovieDTO();
		HttpSession session=request.getSession();
		String id = (String) session.getAttribute("user_id"); 
			
		try {
			request.setCharacterEncoding("UTF-8");
			ArrayList<CommentDTO> cuList=cdao.selectComment_user(id);
			session.setAttribute("cuList", cuList);
			ArrayList<RegisterDTO> mList=rdao.selectUser(id);
			session.setAttribute("ulist", mList);
			
			/*
			for(int i=0;i<cuList.size();i++) {
				String comment_mc=cuList.get(i).getMovie_code();
				ArrayList<MovieDTO> mcList=mdao.selectTitle(comment_mc);
				if(comment_mc.equals(mcList.get(i).getMovie_code())) {
					tList=mcList.get(i);
				}
			}
			session.setAttribute("tList", tList);*/
			RequestDispatcher dispatcher=request.getRequestDispatcher("myPage.jsp"); //forwarding
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
