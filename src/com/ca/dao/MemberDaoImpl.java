package com.ca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ca.pojo.Member;
import com.ca.util.DataConner;

public class MemberDaoImpl implements MemberDao {
	@Override
	public boolean checkRegister(Member s) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DataConner.getConnection(); // 连接数据库
		// 先搜索数据库，查看这个用户是否存在
		String sql = "select * from t_member where m_id='" + s.getM_id() + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) { // 学号已存在，返回ID_EXIST
				flag = false;
			}
			// 学号不存在，则完成注册
			sql = "insert into t_member(m_id, m_name, m_psw) values(?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, s.getM_id());
			pst.setString(2, s.getM_name());
			pst.setString(3, s.getM_psw());
			int row = pst.executeUpdate();
			if (row > 0) {
				flag = true;
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return flag;
	}

	@Override
	public boolean checkLogin(String id, String password) {
		boolean flag = false; // 登录成功 flag = true
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("m_psw").contentEquals(password)) // 如果用户输入的密码正确，成功登录
					flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataConner.close(rs, st, conn);
		}
		return flag;

	}

	@Override
	public String getNameById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String name = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				name = rs.getString("m_name");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return name;
	}

	@Override
	public String getSexById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String sex = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				sex = rs.getString("m_sex");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return sex;
	}

	@Override
	public String getMajorById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String major = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				major = rs.getString("major");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return major;
	}

	@Override
	public String getEmailById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String email = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				email = rs.getString("email");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return email;
	}

	@Override
	public String getPhoneById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String phone = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				phone = rs.getString("phone");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return phone;
	}

	@Override
	public String getDepartmentById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String department = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				department = rs.getString("department");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return department;
	}

	@Override
	public String getPositionById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String position = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				position = rs.getString("position");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return position;
	}

	@Override
	public String getQqById(String id) {
		Connection conn = null;
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		String qq = "";
		conn = DataConner.getConnection(); // 连接数据库
		String sql = "select * from t_member where m_id='" + id + "'";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				qq = rs.getString("qq");
			}
		} catch (

		SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
		return qq;
	}

	@Override
	public void updateMember(Member s) {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DataConner.getConnection(); // 连接数据库

		// 修改学号不存在，则完成修改信息
		String sql = "update t_member set m_name=?," 
						+ "m_sex=?,major=?,email=?," 
						+ "qq=?,phone=? where m_id=?";
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, s.getM_name());
			pst.setString(2, s.getM_sex());
			pst.setString(3, s.getMajor());
			pst.setString(4, s.getEmail());
			pst.setString(5, s.getQq());
			pst.setString(5, s.getQq());
			pst.setString(6, s.getPhone());
			pst.setString(7, s.getM_id());

			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DataConner.close(pst, conn);
		}
	}
}
