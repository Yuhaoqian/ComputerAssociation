package com.ca.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ca.pojo.Activity;
import com.ca.util.DataConner;

public class bannerDao {
	public List<Activity> findTopFiveAct(){
		List<Activity> lstmember=new ArrayList<Activity>();
		String strSQL="select * from activity limit 5";
		Connection conn = DataConner.getConnection();
		ResultSet rs = null;
		Statement st = null;
		try{
			st = conn.createStatement();
			rs = st.executeQuery(strSQL);
			while(rs.next()){
				Activity activity=new Activity();
				activity.setImg(rs.getString("img"));
				activity.setId(rs.getString("act_id"));
				lstmember.add(activity);
			}
			return lstmember;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DataConner.close(rs,st,conn);
		}
	}
}
