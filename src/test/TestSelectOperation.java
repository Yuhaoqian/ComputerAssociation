package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import com.ca.util.DataConner;

public class TestSelectOperation {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DataConner.getConnection(); // 连接数据库

		String sql = "select * from t_article order by postTime desc";

		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(1);
				String title = rs.getString(2);
				String poster = rs.getString(3);
				String postTime = rs.getString(4);
				String type = rs.getString(5);
				String content = rs.getString(6);
				System.out.println(id + '\n'
						+ title + '\n'
						+ poster + '\n'
						+ postTime + '\n'
						+ type + '\n'
						+ content + '\n'
						);
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
