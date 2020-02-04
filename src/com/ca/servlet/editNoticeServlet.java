package com.ca.servlet;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.CastDao;
import com.ca.pojo.Activity;

/**
 * Servlet implementation class editNotice
 */
@WebServlet("/editNoticeServlet")
public class editNoticeServlet extends HttpServlet{
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editNoticeServlet() {
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
		Map<String, String[]> actMap = request.getParameterMap();
		String id = actMap.get("noticeId")[0];
		String theme = actMap.get("noticeTheme")[0];
		double fund = Double.parseDouble(actMap.get("noticeFund")[0]);
		String position = actMap.get("noticePlace")[0];
		String time = actMap.get("noticeTime")[0];
		String img = actMap.get("noticeImg")[0]+".jpg";
		time=time.replace('T', '-');
		time=time.replace(':', '-');
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-kk-mm");
		Date actTime=null;
		try {
			actTime = dateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sponsor = actMap.get("noticeSponsor")[0];
		String content = actMap.get("notice")[0];
		Activity act = new Activity(id,theme,content,position,fund,sponsor,actTime,img);
		CastDao cd = new CastDao();
		cd.updataActByID(act);
	}
}

