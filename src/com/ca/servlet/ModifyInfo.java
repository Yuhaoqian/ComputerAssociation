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
import com.ca.pojo.Member;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ModifyInfo
 */
@WebServlet("/ModifyInfo")
public class ModifyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyInfo() {
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

		String _id = request.getParameter("id");
		String _name = request.getParameter("name");
		String _sex = request.getParameter("sex");
		String _major = request.getParameter("major");
		String _email = request.getParameter("email");
		String _qq = request.getParameter("qq");
		String _phone = request.getParameter("phone");

		JSONObject jo = new JSONObject();
		
		MemberDao mm = new MemberDaoImpl();
		Member s = new Member();
		s.setM_id(_id);
		s.setM_name(_name);
		s.setM_sex(_sex);
		s.setMajor(_major);
		s.setEmail(_email);
		s.setQq(_qq);
		s.setPhone(_phone);
		mm.updateMember(s);
		jo.put("message", "修改成功！");
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(jo.toString());
	}

}
