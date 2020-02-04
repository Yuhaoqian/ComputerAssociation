package com.ca.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.ArticleDaoImpl;
import com.ca.pojo.Article;
import com.ca.util.UnCode;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class WriteArticleServlet
 */
@WebServlet("/WriteArticleServlet")
public class WriteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteArticleServlet() {
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
		
		String title = request.getParameter("title");
		String poster = request.getParameter("poster");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		System.out.println(poster);
		JSONObject jo = new JSONObject();

		
		ArticleDaoImpl am = new ArticleDaoImpl();
		Article art = new Article();
		art.setContent(content);
		art.setPoster(poster);
		art.setTitle(title);
		art.setType(type);
		am.PostArticle(art);

		jo.put("message", "发表文章成功，请等待管理员审核(^｡^)");
		PrintWriter out = response.getWriter();
		out.print(jo);
		out.close();
	}

}
