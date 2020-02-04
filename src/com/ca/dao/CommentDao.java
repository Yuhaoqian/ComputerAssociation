package com.ca.dao;

import java.util.List;
import java.util.Map;

import com.ca.pojo.Comment;

public interface CommentDao {
	public void saveComment(Comment comment);
	public List<Map<String, Object>> getCommentsByArticleId(String id);
}
