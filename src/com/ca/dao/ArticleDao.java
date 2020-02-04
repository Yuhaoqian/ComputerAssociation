package com.ca.dao;

import java.util.List;

import com.ca.pojo.Article;

public interface ArticleDao {
	public List<Article> GetPostArticle();
	public List<Article> GetArticle(int start, int count);
	public void PostArticle(Article art); 
	public List<Article> GetArticleByCategory(String catName);

}
