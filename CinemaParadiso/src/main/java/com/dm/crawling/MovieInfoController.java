package com.dm.crawling;

import java.io.IOException;
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
 * Servlet implementation class MovieInfoController
 */
@WebServlet("/infoSelect.do")
public class MovieInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CinemaCrawling CinemaCrawling= new CinemaCrawling();
		ArrayList<MovieDTO> miList =new ArrayList<>();
		ArrayList<CommentDTO> cList=new ArrayList<CommentDTO>();
		MovieDAO movieDAO = new MovieDAO();
		CommentDAO cDAO = new CommentDAO();
		double aver;
		double rating_sum=0;
		try {
			CinemaCrawling.InfoCrawling(miList);
			movieDAO.insertInfo(miList);
			movieDAO.selectInfo(miList);			
			cList=cDAO.selectComment();
			for(int i=0; i<cList.size() ;i++){
				rating_sum= rating_sum+cList.get(i).getRating();
			}
			aver=rating_sum/cList.size();
			
			String average=String.format("%.1f",aver);
			System.out.println(aver);
			HttpSession session=request.getSession();
			session.setAttribute("miList", miList);
			session.setAttribute("cList", cList);
			session.setAttribute("average", average);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("movieInfoPage.jsp"); //원하는 뷰 선택해서 포워딩
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}