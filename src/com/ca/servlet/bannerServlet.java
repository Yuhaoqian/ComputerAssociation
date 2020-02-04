package com.ca.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.bannerDao;
import com.ca.pojo.Activity;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class bannerServlet
 */
@WebServlet("/bannerServlet")
public class bannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bannerServlet() {
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
		bannerDao dao = new bannerDao();
		List<Activity> list = dao.findTopFiveAct();
		JSONObject jsons = new JSONObject();
		for(int i=0;i<list.size();i++) {
			JSONObject json = new JSONObject();
			json.put("id",list.get(i).getId());
			json.put("img",list.get(i).getImg());
			jsons.put(""+i,json);
		}
		PrintWriter out = response.getWriter();
		out.print(jsons);
		out.close();
	}

}
