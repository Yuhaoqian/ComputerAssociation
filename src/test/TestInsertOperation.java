package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.ca.util.DataConner;

public class TestInsertOperation {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DataConner.getConnection(); // 连接数据库

		String sql = "INSERT INTO t_article(art_id,art_theme,poster,postTime,type,content) "
				+ " VALUES (?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString(); // 主键
		String title = "如何将MyEclipse项目导入eclipse";
		String poster = "Jack";
		String postTime = "2019-11-23 10:43:10";
		String type = "Java Web实用技术";
		String content = "我们经常会在网上下载一些开源项目，或者从别的地方迁移一些项目进来，但经常会发现导入后各种报错。这是初学java肯定会遇到的问题，本文对一些常见的处理方案做一个总结。（本文将MyEclipse项目导入eclipse的过程为例，其他情况也可参考这个流程）";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, title);
			pst.setString(3, poster);
			pst.setString(4, postTime);
			pst.setString(5, type);
			pst.setString(6, content);
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

}
