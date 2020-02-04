package com.ca.servlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.CastDao;
import com.ca.pojo.Member;

/**
 * Servlet implementation class addNotice
 */
@WebServlet("/addRoleServlet")
public class addRoleServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRoleServlet() {
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
		Map<String, String[]> memMap = request.getParameterMap();
		String id = memMap.get("roleID")[0];
		String name = memMap.get("roleName")[0];
		String position = memMap.get("rolePos")[0];
		String pwd = memMap.get("rolePWDCheck")[0];
		String sex = memMap.get("sex")[0];
		String major = memMap.get("roleMajor")[0];
		String email = memMap.get("roleMail")[0];
		String tel = memMap.get("roleTel")[0];
		String depart = memMap.get("roleDep")[0];
		Member mem = new Member(id,pwd,name,sex,major,email,tel,depart,position);
		CastDao cd = new CastDao();
		cd.GetMember(mem);
	}
}
