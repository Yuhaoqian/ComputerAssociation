package com.ca.pojo;

import java.util.Date;

public class Activity {
	private String id;
	private String theme;
	private String content;
	private Date releaseTime;
	private String position;
	private double amount;
	private Date actTime;
	private String sponsor;
	private String img;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Activity(String id,String theme,String content,String position,double amount,String sponsor,Date actTime,String img) {
		this.id=id;
		this.theme=theme;
		this.content=content;
		this.position=position;
		this.amount=amount;
		this.sponsor=sponsor;
		this.releaseTime=new Date();
		this.actTime=releaseTime;
		this.img=img;
	}
	public Activity() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getActTime() {
		return actTime;
	}
	public void setActTime(Date actTime) {
		this.actTime = actTime;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static void main(String[] args) {
		
	}
}