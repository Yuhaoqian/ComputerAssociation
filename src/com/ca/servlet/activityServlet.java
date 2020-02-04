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
import com.ca.pojo.Activity;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class activity
 */
@WebServlet("/activityServlet")
public class activityServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public activityServlet() {
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
		String id = request.getParameter("id");
		if(id==null) {
			PostDao pdm = new PostDao(); 
			List<Activity> list = pdm.GetPostActivity();
			int len = list.size();
			int pageCount = len/10+1;
			JSONObject json = new JSONObject();
			int i=1;
			for(Activity m:list) {
				json.put("act"+i++, m);
			}
			JSONObject dataset = new JSONObject();
			dataset.put("data", json);
			dataset.put("pagecount", pageCount);
			PrintWriter out = response.getWriter();
			out.print(dataset);
			out.close();
		}else {
			PostDao pdm = new PostDao(); 
			Activity a = pdm.GetPostActivity(id);
			JSONObject json = new JSONObject();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            //��ʽ��Ϊ����/ʱ���ַ���
            String acttime=sdf.format(a.getActTime()).substring(0, 16);
            acttime=acttime.substring(0, 10)+"T"+acttime.substring(11);
            String reltime=sdf.format(a.getReleaseTime()).substring(0, 16);
            reltime=reltime.substring(0, 10)+"T"+reltime.substring(11);
            json.put("id", a.getId());
            json.put("theme", a.getTheme());
            json.put("content", a.getContent());
            json.put("releaseTime", reltime);
            json.put("position", a.getPosition());
            json.put("amount", a.getAmount());
            json.put("actTime", acttime);
            json.put("sponsor", a.getSponsor());
            json.put("img", a.getImg());
			PrintWriter out = response.getWriter();
			out.print(json);
			out.close();
		}
	}
}
