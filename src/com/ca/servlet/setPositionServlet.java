package com.ca.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.CastDao;

/**
 * Servlet implementation class assignPer
 */
@WebServlet("/setPositionServlet")
public class setPositionServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setPositionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String position = request.getParameter("rolePos");
		String id = request.getParameter("roleId");
		CastDao cd = new CastDao();
		 cd.updataMemPerByID(id,position); 
	}
}

