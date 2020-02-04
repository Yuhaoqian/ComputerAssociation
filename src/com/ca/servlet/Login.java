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
 * Servlet implementation class index
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		//当form框里面的method为get时，执行doGet方法，
		//使用get提交就必须在服务器端用doGet()方法接收；当form框里面的method为post时，
		//执行doPost方法，使用post提交就必须在服务器端用doPost()方法接收。
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");

		String _id = request.getParameter("id");
		String _password = request.getParameter("password");

		JSONObject jo = new JSONObject();
		MemberDao sm = new MemberDaoImpl();
		boolean flag = sm.checkLogin(_id, _password);
		// 转发地址栏没有变化；重定向地址栏有变化
		if (flag) {
//			response.sendRedirect("/ComputerAssociation/LoginSucceed.jsp");

//			request.getRequestDispatcher("/LoginSucceed.jsp").forward(request, response);
			jo.put("message", "登录成功！");
			jo.put("name", sm.getNameById(_id));
			jo.put("id", _id);
			jo.put("position", sm.getPositionById(_id));
		} else {
			jo.put("message", "学号或密码错误！");

//	        request.setAttribute("msg_login","学号或密码错误！");
//			request.getRequestDispatcher("/index.jsp").forward(request, response);
//			response.sendRedirect("/ComputerAssociation/index.jsp");
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(jo.toString());


	}

}
