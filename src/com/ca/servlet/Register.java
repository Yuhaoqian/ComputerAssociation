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
 * Servlet implementation class register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String _id = request.getParameter("id");
		String _name = request.getParameter("name");
		String _password = request.getParameter("password");
		JSONObject jo = new JSONObject();
		
		MemberDao mm = new MemberDaoImpl();
		Member s = new Member();
		s.setM_id(_id);
		s.setM_name(_name);
		s.setM_psw(_password);
		boolean flag = mm.checkRegister(s);
		if (flag) {
			jo.put("message", "注册成功！");
//	        request.setAttribute("msg_register","注册成功！");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			jo.put("message", "该学号已被注册！");
//			response.sendRedirect("LoginFailed.jsp");
//	        request.setAttribute("msg_register","该学号已被注册！");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(jo.toString());
	}

}
