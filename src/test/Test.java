package test;

import java.util.List;

import com.ca.dao.ArticleDaoImpl;
import com.ca.pojo.Article;

public class Test {
	public static void main(String[] args) {
//
//		CommentManageImpl cm = new CommentManageImpl();
//		System.out.println(cm.getCommentsByArticleId("108be96c-10c0-4116-860d-d69348ab8da7"));
		ArticleDaoImpl am = new ArticleDaoImpl();
		List<Article>  list = am.GetArticleByCategory("C/C++");
		System.out.println(list);
		
	}
}
