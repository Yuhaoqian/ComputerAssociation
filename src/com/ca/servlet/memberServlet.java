package com.ca.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.PostDao;
import com.ca.pojo.Member;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class member
 */
@WebServlet("/memberServlet")
public class memberServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberServlet() {
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
		if(id==null) {
			PostDao pdm = new PostDao(); 
			List<Member> list = pdm.GetPostMember();
			JSONObject json = new JSONObject();
			int i=1;
			int len = list.size();
			int pageCount = len/10+1;
			for(Member m:list) {
				json.put("mem"+i++, m);
			}
			JSONObject dataset = new JSONObject();
			dataset.put("data", json);
			dataset.put("pagecount", pageCount);
			PrintWriter out = response.getWriter();
			out.print(dataset);
			out.close();
		}else {
			PostDao pdm = new PostDao(); 
			Member m = pdm.GetPostMember(id);
			JSONObject json = new JSONObject();
            json.put("id", m.getM_id());
            json.put("name", m.getM_name());
            json.put("sex", m.getM_sex());
            json.put("major", m.getMajor());
            json.put("email", m.getEmail());
            json.put("phone", m.getPhone());
            json.put("department", m.getDepartment());
            json.put("position", m.getPosition());
			PrintWriter out = response.getWriter();
			out.print(json);
			out.close();
		}
	}
}
