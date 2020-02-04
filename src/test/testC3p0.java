package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ca.pojo.Article;
import com.ca.util.DBUtils;

public class testC3p0 {
	public static void main(String[] args) {
		List<Article> articleList = new ArrayList<Article>();
		String strSQL = "select * from t_article where status = '已通过' ORDER BY postTime desc";
		// 拿到连接池
		DataSource ds = DBUtils.getDataSource();
		// 使用Apache DBUtils工具时，需要QueryRunner对象
		QueryRunner run = new QueryRunner(ds);
		
		try {
			articleList = run.query(strSQL, new BeanListHandler<>(Article.class));
			System.out.println(articleList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < articleList.size(); i++) {
			System.out.println(articleList.get(i).getId());
		}
//		return articleList;
	}
}
