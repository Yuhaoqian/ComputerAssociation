// 
// Decompiled by Procyon v0.5.36
// 

package com.ca.servlet;

import java.util.Date;
import java.util.Map;
import com.ca.dao.fundDao;
import com.ca.pojo.Fund;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/addFundServlet" })
public class addFundServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        final Map<String, String[]> fundMap = (Map<String, String[]>)request.getParameterMap();
        final String id = fundMap.get("fundID")[0];
        final String purpose = fundMap.get("fundPurpose")[0];
        final double fund = Double.parseDouble(fundMap.get("fundAmount")[0]);
        final String userId = fundMap.get("userId")[0];
        String time = fundMap.get("fundTime")[0];
        final double totalFund = Double.parseDouble(fundMap.get("totalAmount")[0]);
        time = time.replace('T', '-');
        time = time.replace(':', '-');
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-kk-mm");
        Date fundTime = null;
        System.out.println("Jfang");
        try {
            fundTime = dateFormat.parse(time);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        final Fund f = new Fund(id, purpose, fund, fundTime, userId, totalFund);
        final fundDao dao = new fundDao();
        System.out.println("jjjj");
        dao.addFund(f);
    }
}
