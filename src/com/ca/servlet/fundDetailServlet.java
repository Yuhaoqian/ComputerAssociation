// 
// Decompiled by Procyon v0.5.36
// 

package com.ca.servlet;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;
import com.ca.pojo.Fund;
import net.sf.json.JSONObject;
import com.ca.dao.fundDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet({ "/fundDetailServlet" })
public class fundDetailServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        final String id = request.getParameter("id");
        if (id == null) {
            final fundDao dao = new fundDao();
            final List<Fund> list = (List<Fund>)dao.getAllFund();
            final JSONObject json = new JSONObject();
            int i = 1;
            final int len = list.size();
            final int pageCount = len / 10 + 1;
            for (final Fund f : list) {
                final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                final String time = sdf.format(f.getExpand_time());
                final JSONObject fund = new JSONObject();
                fund.put((Object)"id", (Object)f.getF_id());
                fund.put((Object)"purpose", (Object)f.getF_purpose());
                fund.put((Object)"amount", (Object)f.getAmount());
                fund.put((Object)"time", (Object)time);
                json.put((Object)("fund" + i++), (Object)fund);
            }
            final JSONObject dataset = new JSONObject();
            dataset.put((Object)"data", (Object)json);
            dataset.put((Object)"pagecount", (Object)pageCount);
            final PrintWriter out = response.getWriter();
            out.print(dataset);
            out.close();
        }
        else {
            final fundDao dao = new fundDao();
            final Fund f2 = dao.findFundBiId(id);
            final JSONObject json = new JSONObject();
            final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time2 = sdf2.format(f2.getExpand_time()).substring(0, 16);
            time2 = String.valueOf(time2.substring(0, 10)) + "T" + time2.substring(11);
            json.put((Object)"id", (Object)f2.getF_id());
            json.put((Object)"purpose", (Object)f2.getF_purpose());
            json.put((Object)"amount", (Object)f2.getAmount());
            json.put((Object)"time", (Object)time2);
            json.put((Object)"userId", (Object)f2.getUser_id());
            json.put((Object)"totalAmount", (Object)f2.getTotal_amount());
            final PrintWriter out2 = response.getWriter();
            out2.print(json);
            out2.close();
        }
    }
}
