package com.ca.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.MemberDao;
import com.ca.dao.MemberDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Info
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String _id = request.getParameter("id");

		JSONObject jo = new JSONObject();
		MemberDao sm = new MemberDaoImpl();
		
		jo.put("sex", sm.getSexById(_id));
		jo.put("major", sm.getMajorById(_id));
		jo.put("email", sm.getEmailById(_id));
		jo.put("phone", sm.getPhoneById(_id));
		jo.put("qq", sm.getQqById(_id));


		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(jo.toString());
	}

}
