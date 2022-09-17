package servlet;

import beans.Merchant;
import dao.MerchantDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddMerchant")
public class AddMerchant extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        Merchant merchant = new Merchant();
        merchant.setName(name);
        merchant.setPassword(password);
        String sql = "insert into tb_merchant(name,password) values(?,?)";
        MerchantDao cp = new MerchantDao();
        cp.insertMerchant(merchant, sql);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print("<script> alert(\"添加成功!\");</script>");
        resp.setHeader("refresh", "1,url=regMerchant.jsp");
    }
}
