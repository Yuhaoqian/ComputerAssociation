package com.ca.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ca.dao.CommentDaoImpl;
import com.ca.pojo.Comment;
import com.ca.util.UnCode;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class WriteCommentServlet
 */
@WebServlet("/WriteCommentServlet")
public class WriteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String content = request.getParameter("content");
		String art_id = request.getParameter("art_id");
		String m_id = request.getParameter("m_id");

		CommentDaoImpl cm = new CommentDaoImpl();
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setArticleId(art_id);
		comment.setUserId(m_id);
		cm.saveComment(comment);
		
		JSONObject jo = new JSONObject();
		jo.put("message", "发表评论成功");
		
		PrintWriter out = response.getWriter();
		out.print(jo);
		out.close();
	}
}
