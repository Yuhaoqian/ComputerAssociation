package com.ca.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ca.pojo.Activity;
import com.ca.pojo.Article;
import com.ca.pojo.Fund;
import com.ca.pojo.Member;
import com.ca.util.DataConner;

public class PostDao {
	 
		public List<Member> GetPostMember(){
			List<Member> lstmember=new ArrayList<Member>();
			String strSQL="select * from t_member";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					Member member=new Member();
					member.setM_id(rs.getString("m_id"));
					member.setM_psw(rs.getString("m_psw"));
					member.setM_name(rs.getString("m_name"));
					member.setM_sex(rs.getString("m_sex"));
					member.setMajor(rs.getString("major"));
					member.setEmail(rs.getString("email"));
					member.setPhone(rs.getString("phone"));
					member.setDepartment(rs.getString("department"));
					member.setPosition(rs.getString("position"));
					lstmember.add(member);
				}
				return lstmember;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
			
		}
		public String GetPostMemberPos(String id){
			String attr = "";
			String strSQL="select m_id,position from t_member where m_id='"+id+"'";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					attr=rs.getString("position");
				}
				return attr;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
		}
		public Member GetPostMember(String id){
			Member member=new Member();
			String strSQL="select * from t_member where m_id='"+id+"'";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					member.setM_id(rs.getString("m_id"));
					member.setM_psw(rs.getString("m_psw"));
					member.setM_name(rs.getString("m_name"));
					member.setM_sex(rs.getString("m_sex"));
					member.setMajor(rs.getString("major"));
					member.setEmail(rs.getString("email"));
					member.setPhone(rs.getString("phone"));
					member.setDepartment(rs.getString("department"));
					member.setPosition(rs.getString("position"));
				}
				return member;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
		}
		public List<Activity> GetPostActivity(){
			List<Activity> lstactivity=new ArrayList<Activity>();
			String strSQL="select * from activity";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					Activity activity=new Activity();
					activity.setId(rs.getString("act_id"));
					activity.setTheme(rs.getString("act_theme"));
					activity.setContent(rs.getString("content"));
					//activity.setReleaseTime(rs.getDate("rel_time"));
					activity.setPosition(rs.getString("position"));
					activity.setAmount(rs.getDouble("amount"));
					//activity.setActTime(rs.getDate("act_time"));
					activity.setSponsor(rs.getString("sponsor_id"));
					lstactivity.add(activity);
				}
				return lstactivity;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
			
		}
		public Activity GetPostActivity(String id){
			Activity activity=new Activity();
			String strSQL="select * from activity where act_id='"+id+"'";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					activity.setId(rs.getString("act_id"));
					activity.setTheme(rs.getString("act_theme"));
					activity.setContent(rs.getString("content"));
					activity.setReleaseTime(rs.getTimestamp("rel_time"));
					activity.setPosition(rs.getString("position"));
					activity.setAmount(rs.getDouble("amount"));
					activity.setActTime(rs.getTimestamp("act_time"));
					activity.setSponsor(rs.getString("sponsor_id"));
					activity.setImg(rs.getString("img"));
				}
				
				return activity;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
			
		}
		public List<Article> GetPostArticle(String status){
			List<Article> lstarticle=new ArrayList<Article>();
			String strSQL="select * from t_article where status='"+status+"'";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					Article article=new Article();
					article.setId(rs.getString("art_id"));
					article.setTitle(rs.getString("art_theme"));
					article.setContent(rs.getString("content"));
					article.setType(rs.getString("type"));
					article.setPoster(rs.getString("poster"));
					article.setPostTime(rs.getTimestamp("postTime"));
					article.setStatus(rs.getString("status"));
					lstarticle.add(article);
				}
				return lstarticle;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
			
		}
		public List<Fund> GetPostFund(){
			List<Fund> lstfund=new ArrayList<Fund>();
			String strSQL="select * from t_fund";
			Connection conn = DataConner.getConnection();
			ResultSet rs = null;
			Statement st = null;
			try{
				st = conn.createStatement();
				rs = st.executeQuery(strSQL);
				while(rs.next()){
					Fund fund=new Fund();
					fund.setF_id(rs.getString("f_id"));
					fund.setF_purpose(rs.getString("f_purpose"));
					fund.setAmount(rs.getDouble("amount"));
					fund.setTotal_amount(rs.getDouble("total_amount"));
					fund.setUser_id(rs.getString("user_id"));
					lstfund.add(fund);
				}
				return lstfund;
			} catch(Exception e){
				e.printStackTrace();
				return null;
			}finally{
				DataConner.close(rs,st,conn);
			}
			
		}
}
