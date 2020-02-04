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
import com.ca.pojo.Fund;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class activity
 */
@WebServlet("/fundServlet")
public class fundServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fundServlet() {
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
		PostDao pdm = new PostDao(); 
		List<Fund> list = pdm.GetPostFund();
		JSONObject json = new JSONObject();
		int i=1;
		for(Fund m:list) {
			json.put("fund"+i++, m);
		}
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}
}

