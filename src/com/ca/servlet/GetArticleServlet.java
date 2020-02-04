package com.ca.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.PostDao;
import com.ca.pojo.Article;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class article
 */
@WebServlet("/GetArticleServlet")
public class GetArticleServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetArticleServlet() {
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
		List<Article> list = pdm.GetPostArticle("未通过");
		List<Article> list2 = pdm.GetPostArticle("已通过");
		list.addAll(list2);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getStatus());
		}
		JSONArray jsonArray = new JSONArray();

		JSONObject json = new JSONObject();
		int i=1;
		int len = list.size();
		int pageCount = len/5+1;
		for(Article m:list) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String posttime=sdf.format(m.getPostTime());
			JSONObject art = new JSONObject();
			art.put("id",m.getId());
			art.put("title",m.getTitle());
			art.put("poster",m.getPoster());
			art.put("postTime",posttime);
			art.put("type",m.getType());
			art.put("content",m.getContent());
			art.put("content",m.getContent());
			art.put("status",m.getStatus());
			json.put("art"+i++, art);
		}
		JSONObject dataset = new JSONObject();
		dataset.put("data", json);
		dataset.put("pagecount", pageCount);
		PrintWriter out = response.getWriter();
		out.print(dataset);
		out.close();
	}
}
