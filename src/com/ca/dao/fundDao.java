// 
// Decompiled by Procyon v0.5.36
// 

package com.ca.dao;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.Date;
import com.ca.util.DataConner;
import java.util.ArrayList;
import com.ca.pojo.Fund;
import java.util.List;

public class fundDao
{
    public List<Fund> getAllFund() {
        final List<Fund> list = new ArrayList<Fund>();
        final String strSQL = "select * from t_fund";
        final Connection conn = DataConner.getConnection();
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(strSQL);
            while (rs.next()) {
                final Fund fund = new Fund();
                fund.setF_id(rs.getString("f_id"));
                fund.setF_purpose(rs.getString("f_purpose"));
                fund.setAmount(rs.getDouble("amount"));
                fund.setExpand_time((Date)rs.getTimestamp("expand_time"));
                fund.setUser_id(rs.getString("user_id"));
                fund.setTotal_amount(rs.getDouble("total_amount"));
                list.add(fund);
            }
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DataConner.close(rs, st, conn);
        }
    }
    
    public void addFund(final Fund fund) {
        final String sql = "insert into t_fund values (?,?,?,?,?,?)";
        System.out.println("\u8c03\u7528\u6211\u4e86\uff01\uff01\uff01");
        final Connection conn = DataConner.getConnection();
        System.out.println(sql);
        final ResultSet rs = null;
        final Statement st = null;
        try {
            final PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, fund.getF_id());
            ptmt.setString(2, fund.getF_purpose());
            ptmt.setDouble(3, fund.getAmount());
            ptmt.setTimestamp(4, new Timestamp(fund.getExpand_time().getTime()));
            ptmt.setString(5, fund.getUser_id());
            ptmt.setDouble(6, fund.getTotal_amount());
            ptmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            DataConner.close(rs, st, conn);
        }
        DataConner.close(rs, st, conn);
    }
    
    public void updataFundById(final Fund fund) {
        final String sql = "update t_fund set f_purpose =?,amount=?,expand_time=?,user_id =?,total_amount=? where f_id=?";
        final Connection conn = DataConner.getConnection();
        final ResultSet rs = null;
        final Statement st = null;
        try {
            final PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(6, fund.getF_id());
            ptmt.setString(1, fund.getF_purpose());
            ptmt.setDouble(2, fund.getAmount());
            ptmt.setTimestamp(3, new Timestamp(fund.getExpand_time().getTime()));
            ptmt.setString(4, fund.getUser_id());
            ptmt.setDouble(5, fund.getTotal_amount());
            ptmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            DataConner.close(rs, st, conn);
        }
        DataConner.close(rs, st, conn);
    }
    
    public Fund findFundBiId(final String id) {
        final Fund fund = new Fund();
        final String strSQL = "select * from t_fund where f_id='" + id + "'";
        final Connection conn = DataConner.getConnection();
        ResultSet rs = null;
        Statement st = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(strSQL);
            while (rs.next()) {
                fund.setF_id(rs.getString("f_id"));
                fund.setF_purpose(rs.getString("f_purpose"));
                fund.setAmount(rs.getDouble("amount"));
                fund.setExpand_time((Date)rs.getTimestamp("expand_time"));
                fund.setUser_id(rs.getString("user_id"));
                fund.setTotal_amount(rs.getDouble("total_amount"));
            }
            return fund;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            DataConner.close(rs, st, conn);
        }
    }
    
    public void delFundById(final String[] ids) {
        final String sql = "delete from t_fund where f_id=?";
        final Connection conn = DataConner.getConnection();
        final ResultSet rs = null;
        final Statement st = null;
        try {
            for (final String id : ids) {
                final PreparedStatement ptmt = conn.prepareStatement(sql);
                ptmt.setString(1, id);
                ptmt.executeUpdate();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }
        finally {
            DataConner.close(rs, st, conn);
        }
        DataConner.close(rs, st, conn);
    }
}
