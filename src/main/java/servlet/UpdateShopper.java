package servlet;
import beans.Shop;
import dao.ShopDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/UpdateShopper")
public class UpdateShopper extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        System.out.println(id);
        int phone = Integer.parseInt(request.getParameter("phone"));
//        System.out.println(phone);

        HashMap<String, Shop> list = (HashMap<String, Shop>) request.getSession().getAttribute("list");
        list.get(id).setPhone(Integer.valueOf(phone));

        new ShopDao().updateAndDelete("update tb_shoper set phone='"+phone+"' where id='"+id+"'");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<p>更新成功！</p>");
        response.setHeader("refresh", "1,url=/showShopper.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
