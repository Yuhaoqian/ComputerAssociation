package com.ca.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Article {
	private String id;  //文章id
	private String title;  //标题
	private String poster; //作者
	private Date postTime; //上传时间
	private String postTimeStr; 
	private String type;  //文章类型
	private String content;  //文章内容
	private String status; //文章是否被通过
	
	public String getPostTimeStr() {
		return postTimeStr;
	}
	public void setPostTimeStr(String postTimeStr) {
		this.postTimeStr = postTimeStr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}



}

