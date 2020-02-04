package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ca.pojo.Comment;
import com.ca.util.DataConner;

public class CommentDaoImpl implements CommentDao {

	@Override
	public void saveComment(Comment comment) {
		String sql = "insert into t_comment(c_id, m_id, content, art_id, createTime)" + "values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DataConner.getConnection(); // 连接数据库

		String c_id = UUID.randomUUID().toString(); // 生成评论的id号
		// 获取当前的日期
		Date date = new Date();
		// 设置要获取到什么样的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 获取String类型的时间
		String postTime = sdf.format(date);

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, c_id);
			pst.setString(2, comment.getUserId());
			pst.setString(3, comment.getContent());
			pst.setString(4, comment.getArticleId());
			pst.setString(5, postTime);
			int row = pst.executeUpdate();
			if (row > 0) {
				System.out.println("评论增加成功！");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
	}

	@Override
	public List<Map<String, Object>> getCommentsByArticleId(String id) {
		List<Map<String, Object>> listMaps = new ArrayList<Map<String, Object>>();
		String strSQL = "select b.m_name ,a.content, a.createTime from t_comment a left JOIN t_member b " +
	             "on a.m_id = b.m_id  where a.art_id = ? order by a.createTime desc";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(strSQL);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {

	            Map<String, Object> map = new HashMap<String, Object>();  
	            map.put("content", rs.getString(2));  
	            map.put("m_name", rs.getString(1));  
	            map.put("createTime", rs.getString(3));  

	            listMaps.add(map);
			}
			return listMaps;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DataConner.close(rs, pst, conn);
		}

	}

}
