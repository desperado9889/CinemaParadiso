package com.dm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.paradiso.RegisterDAO;
import com.dm.paradiso.RegisterDTO;

/**
 * Servlet implementation class ModifyPassword
 */
@WebServlet("/pmodify.do")
public class ModifyPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String old=request.getParameter("old");
		String newer=request.getParameter("new");
		RegisterDAO rd = new RegisterDAO();
		RegisterDTO rt = new RegisterDTO();
		HttpSession session=request.getSession();
		String id = (String) session.getAttribute("user_id");
		
		rt.setId(id);
		try {
			int pwCheck=rd.selectPassword(id, old);
			System.out.println(pwCheck);
			if(pwCheck==1) {
				rt.setPassword(newer);
				rd.modifyUserP(rt);
				RequestDispatcher
				dispatcher=request.getRequestDispatcher("success_p.jsp"); //원하는 뷰 선택해서 포워딩
				dispatcher.forward(request, response); //<jsp:forward>와 같음
			}
			else {
				RequestDispatcher
				dispatcher=request.getRequestDispatcher("error_p.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
