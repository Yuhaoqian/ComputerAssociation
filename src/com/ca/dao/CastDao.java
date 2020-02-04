package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.ca.pojo.Activity;
import com.ca.pojo.Member;
import com.ca.util.DataConner;

public class CastDao {
	public void GetActivity(Activity act){
		String sql = "insert into activity values (?,?,?,?,?,?,?,?,?)";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, act.getId());
			ptmt.setString(2, act.getTheme());
			ptmt.setTimestamp(3, new Timestamp(act.getActTime().getTime()));
			ptmt.setString(4, act.getPosition());
			ptmt.setDouble(5, act.getAmount());
			ptmt.setTimestamp(6, new Timestamp(act.getReleaseTime().getTime()));
			ptmt.setString(7, act.getSponsor());
			ptmt.setString(8, act.getContent());
			ptmt.setString(9, act.getImg());
			ptmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	
	public void updataActByID(Activity act){
		String sql = "update activity set act_theme =?,rel_time =?,position=?,amount=?,act_time =?,sponsor_id=?,content =?,img=? where act_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(8, act.getId());
			ptmt.setString(1, act.getTheme());
			ptmt.setTimestamp(2, new Timestamp(act.getActTime().getTime()));
			ptmt.setString(3, act.getPosition());
			ptmt.setDouble(4, act.getAmount());
			ptmt.setTimestamp(5, new Timestamp(act.getReleaseTime().getTime()));
			ptmt.setString(6, act.getSponsor());
			ptmt.setString(7, act.getContent());
			ptmt.setString(8, act.getImg());
			ptmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void updataMemByID(Member mem){
		String sql = "update t_member set m_name =?,m_sex =?,major =?,email =?,phone =?,department =?,position=? where m_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(8, mem.getM_id());
			ptmt.setString(1, mem.getM_name());
			ptmt.setString(2, mem.getM_sex());
			ptmt.setString(3, mem.getMajor());
			ptmt.setString(4, mem.getEmail());
			ptmt.setString(5, mem.getPhone());
			ptmt.setString(6, mem.getDepartment());
			ptmt.setString(7, mem.getPosition());
			ptmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void updataMemPerByID(String id,String position){
		String sql = "update t_member set position=? where m_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, position);
			ptmt.setString(2, id);
			ptmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void delActByID(String[] ids){
		String sql = "delete from activity where act_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			for(String id:ids) {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, id);
				ptmt.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void delArtByID(String[] ids){
		String sql = "delete from t_article where art_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			for(String id:ids) {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, id);
				ptmt.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void passArtByID(String[] ids){
		String sql = "update t_article set status='已通过' where art_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			for(String id:ids) {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, id);
				ptmt.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void delMemByID(String[] ids){
		String sql = "delete from t_member where m_id=?";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			for(String id:ids) {
				PreparedStatement ptmt = conn.prepareStatement(sql);
				ptmt.setString(1, id);
				ptmt.executeUpdate();
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
	public void GetMember(Member mem){
		String sql = "insert into t_member values (?,?,?,?,?,?,?,?,?)";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, mem.getM_id());
			ptmt.setString(2, mem.getM_psw());
			ptmt.setString(3, mem.getM_name());
			ptmt.setString(4, mem.getM_sex());
			ptmt.setString(5, mem.getMajor());
			ptmt.setString(6, mem.getEmail());
			ptmt.setString(7, mem.getPhone());
			ptmt.setString(8, mem.getDepartment());
			ptmt.setString(9, mem.getPosition());
			ptmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			DataConner.close(rs,st,conn);
		}
		
	}
}
