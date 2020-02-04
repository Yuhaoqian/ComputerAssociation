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
import com.ca.util.Page;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
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
		// 获取分页参数
		int start = 0;
		int count = 5;
		
		Page page = new Page(start, count);
		
		ArticleDaoImpl am = new ArticleDaoImpl();
		List<Article> list = am.GetPostArticle();
		int total = list.size(); // 记录总记录数
		page.setTotal(total);
		int totalPage = page.getTotalPage(); // 计算得到总页数
		
//		List<Article> list = am.GetArticle(start, count); // 得到数据库从[start+1,start+5]的记录
		
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("count", count);
		jo.put("totalPage", totalPage);
		jsonArray.add(jo);
		for(Article m:list) {
			jsonArray.add(m);
		}
		PrintWriter out = response.getWriter();
		out.print(jsonArray);
		out.close();
	}

}
