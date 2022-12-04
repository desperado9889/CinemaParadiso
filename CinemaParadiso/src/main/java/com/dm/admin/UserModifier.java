package com.dm.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dm.paradiso.RegisterDAO;
import com.dm.paradiso.RegisterDTO;

/**
 * Servlet implementation class UserModifier
 */
@WebServlet("/modify.do")
public class UserModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserModifier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String m=request.getParameter("id");
		String p=request.getParameter("password");
		String n=request.getParameter("name");
		String d=request.getParameter("date");
		RegisterDTO rt = new RegisterDTO();
		rt.setPassword(p);
		rt.setName(n);
		rt.setDate(d);
		rt.setId(m);
		RegisterDAO rd=new RegisterDAO();
		try {
			rd.modifyUser(rt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
 
		 RequestDispatcher
		 dispatcher=request.getRequestDispatcher("admin_user.do"); //원하는 뷰 선택해서 포워딩
		 dispatcher.forward(request, response); //<jsp:forward>와 같음
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
