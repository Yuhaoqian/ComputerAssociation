package com.ca.pojo;
public class Member {
	// 社团成员id
	private String m_id;
	// 社团成员密码
	private String m_psw;
	// 社团成员姓名
	private String m_name;
	// 社团成员性别
	private String m_sex;
	// 社团成员专业
	private String major;
	// 社团成员qq
	private String qq;
	// 社团成员邮箱
	private String email;
	// 社团成员手机号
	private String phone;
	// 社团成员所属部门部门
	private String department;
	// 社团成员职位
	private String position;
	public Member() {
		
	}
	
	public Member(String m_id,String m_psw,String m_name,String m_sex,String major,String email,String phone,String department,String position) {
		this.m_id=m_id;
		this.m_psw=m_psw;
		this.m_name=m_name;
		this.m_sex=m_sex;
		this.major=major;
		this.email=email;
		this.phone=phone;
		this.department=department;
		this.position=position;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_psw() {
		return m_psw;
	}
	public void setM_psw(String m_psw) {
		this.m_psw = m_psw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_sex() {
		return m_sex;
	}
	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}



}

