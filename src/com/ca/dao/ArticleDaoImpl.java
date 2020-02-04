package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ca.pojo.Article;
import com.ca.util.DataConner;

public class ArticleDaoImpl implements ArticleDao{
	public List<Article> GetPostArticle() {
		List<Article> articleList = new ArrayList<Article>();
		String strSQL = "select * from t_article where status='已通过' order by postTime desc";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(strSQL);
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getString("art_id"));
				article.setTitle(rs.getString("art_theme"));
				article.setContent(rs.getString("content"));
				article.setType(rs.getString("type"));
				article.setPostTime(rs.getTimestamp("postTime"));
		        //设置要获取到什么样的时间
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        //获取String类型的时间
		        String postTimeStr = sdf.format(article.getPostTime());
				article.setPostTimeStr(postTimeStr);
				
				article.setPoster(rs.getString("poster"));
				articleList.add(article);
			}
			return articleList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DataConner.close(rs, st, conn);
		}
	}
	public void PostArticle(Article art) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DataConner.getConnection(); // 连接数据库

		String sql = "INSERT INTO t_article(art_id,art_theme,poster,postTime,type,content,status) "
				+ " VALUES (?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString(); // 生成文章的id号	
		// 获取当前的日期
        Date date = new Date();
//        //设置要获取到什么样的时间
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //获取String类型的时间
//        String postTime = sdf.format(date);
        Timestamp ts = new Timestamp(date.getTime());
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, art.getTitle());
			pst.setString(3, art.getPoster());
			pst.setTimestamp(4, ts);
			pst.setString(5, art.getType());
			pst.setString(6, art.getContent());
			pst.setString(7, "未通过");
			int row = pst.executeUpdate();
			if (row > 0) {
				System.out.println("新增成功！");
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
	public List<Article> GetArticle(int start, int count) {
		List<Article> articleList = new ArrayList<Article>();
		String strSQL = "select * from t_article ORDER BY postTime desc limit ?,?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(strSQL);
			pst.setInt(1, start);
			pst.setInt(2, count);
			rs = pst.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getString("art_id"));
				article.setTitle(rs.getString("art_theme"));
				article.setContent(rs.getString("content"));
				article.setType(rs.getString("type"));
				article.setPostTime(rs.getTimestamp("postTime"));
				article.setPoster(rs.getString("poster"));
				articleList.add(article);
			}
			return articleList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DataConner.close(rs, pst, conn);
		}

	}
	@Override
	public List<Article> GetArticleByCategory(String catName) {
		List<Article> articleList = new ArrayList<Article>();
		String strSQL = "select * from t_article where type=? ORDER BY postTime desc";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(strSQL);
			pst.setString(1, catName);
			rs = pst.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getString("art_id"));
				article.setTitle(rs.getString("art_theme"));
				article.setContent(rs.getString("content"));
				article.setType(rs.getString("type"));
				article.setPostTime(rs.getTimestamp("postTime"));
				article.setPoster(rs.getString("poster"));
				articleList.add(article);
			}
			return articleList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DataConner.close(rs, pst, conn);
		}

	}

}
