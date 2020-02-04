package test;

import java.util.UUID;

import com.ca.dao.CommentDaoImpl;
import com.ca.pojo.Comment;

public class TestComment {
	public static void main(String[] args) {
		CommentDaoImpl cm = new CommentDaoImpl();
		Comment comment = new Comment();
		comment.setId(UUID.randomUUID().toString());
		comment.setContent("8535348！");
		comment.setArticleId("108be96c-10c0-4116-860d-d69348ab8da7");
		comment.setUserId("172219605201");
		cm.saveComment(comment);
		System.out.println("保存成功！");
	}
}
