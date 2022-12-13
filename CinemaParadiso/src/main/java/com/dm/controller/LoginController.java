package com.dm.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dm.paradiso.RegisterDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterDAO rdao=new RegisterDAO();
		try {
			String id=request.getParameter("id");
			String pw=request.getParameter("password");
			int loginCheck= rdao.loginCheck(id, pw);
			String msg= new String();
			String page= new String();
			System.out.println(id+","+pw);
			if(loginCheck==1) {
				// session 객체 인스턴스
				request.setAttribute("loginCheck", loginCheck);
				HttpSession session = request.getSession();
				session.setAttribute("user_login", "accept");
				session.setAttribute("user_id", id);
			    session.setAttribute("message", msg);
			    if(id.equals("admin")&&pw.equals("a123!")) {
			    	page="/adminPage.jsp";
			    	response.sendRedirect(request.getContextPath() + page);
				}	
			    else {
			    	response.sendRedirect("posterSelect.do");
			    }
			} else {
				request.setAttribute("loginCheck", loginCheck);
				msg = "아이디 또는 비밀번호가 일치하지 않습니다.";
				page = "/error.jsp?message="+URLEncoder.encode(msg, "utf-8");
				response.sendRedirect(request.getContextPath() + page);	
			}
		} catch (IOException e) {
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
