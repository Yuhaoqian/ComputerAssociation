// 
// Decompiled by Procyon v0.5.36
// 

package com.ca.pojo;

import java.util.Date;

public class Fund
{
    private String f_id;
    private String f_purpose;
    private double amount;
    private Date expand_time;
    private String user_id;
    private double total_amount;
    
    public Fund() {
    }
    
    public Fund(final String f_id, final String f_purpose, final double amount, final Date expand_time, final String user_id, final double total_amount) {
        this.f_id = f_id;
        this.f_purpose = f_purpose;
        this.amount = amount;
        this.expand_time = expand_time;
        this.user_id = user_id;
        this.total_amount = total_amount;
    }
    
    public String getF_id() {
        return this.f_id;
    }
    
    public void setF_id(final String f_id) {
        this.f_id = f_id;
    }
    
    public String getF_purpose() {
        return this.f_purpose;
    }
    
    public void setF_purpose(final String f_purpose) {
        this.f_purpose = f_purpose;
    }
    
    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(final double amount) {
        this.amount = amount;
    }
    
    public Date getExpand_time() {
        return this.expand_time;
    }
    
    public void setExpand_time(final Date expand_time) {
        this.expand_time = expand_time;
    }
    
    public String getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final String user_id) {
        this.user_id = user_id;
    }
    
    public double getTotal_amount() {
        return this.total_amount;
    }
    
    public void setTotal_amount(final double total_amount) {
        this.total_amount = total_amount;
    }
}
