package com.ca.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.PostDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class member
 */
@WebServlet("/assignServlet")
public class assignServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public assignServlet() {
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
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub PostDaoMember pdm = new PostDaoMember(); List<Member> list=
	 * pdm.GetPost(); request.setAttribute("list",list);
	 * 
	 * request.getRequestDispatcher("/testrole.jsp").forward(request, response); }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		PostDao pdm = new PostDao(); 
		String attr = pdm.GetPostMemberPos(id);
		JSONObject json = new JSONObject();
		json.put("id",id);
        json.put("per", attr);
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();

	}
}
