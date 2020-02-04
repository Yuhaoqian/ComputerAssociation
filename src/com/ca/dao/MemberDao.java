package com.ca.dao;

import com.ca.pojo.Member;

public interface MemberDao {
	public boolean checkRegister(Member s);
	public boolean checkLogin(String id, String password);
	
	public void updateMember(Member s);
	
	public String getNameById(String id);
	public String getSexById(String id);
	public String getMajorById(String id);
	public String getEmailById(String id);
	public String getPhoneById(String id);
	public String getQqById(String id);

	public String getDepartmentById(String id);
	public String getPositionById(String id);
	
}
