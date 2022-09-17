package servlet;

import beans.Merchant;
import beans.User;
import dao.MerchantDao;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/SubmitResult2")
public class SubmitResult2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        PrintWriter out = response.getWriter();
        if (!code.equals(randStr)) {
            System.out.println("code.equals(randStr)");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            out.print("<script> alert(\"验证码错误! \");</script>");
            response.setHeader("refresh", "1,url=/login.jsp");
        } else {
            String type = request.getParameter("usertype");
            String acc = request.getParameter("account");
            String pwd = request.getParameter("password");
            int count = 0;
            System.out.println(type);
/*            switch (type){
                case "customer":break;
                case "merchant":break;
                case "manager":break;
            }*/
            if (type.equals("customer")) {
                HashMap<String, User> list = new HashMap<>();
                UserDao userDao = new UserDao();
                try {
                    list = userDao.getAllUser();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                for (User user1 : list.values()) {
                    count++;
                    if (user1.getName().equals(acc) && user1.getPassword().equals(pwd)) {
                        session.setAttribute("user", acc);
                        response.getWriter().print("<p>Signing in</p>");
                        response.setHeader("refresh", "1,url=/DoGet");
                        count--;//目的是处理列表的最后一个数据,确保count最后的值小于列表的长度
                        break;
                    }
                }
/*                System.out.println(list.size());
                System.out.println(count);*/
                if (count == list.size()) {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print("<script> alert(\"账号或密码错误! \");</script>");
                    response.setHeader("refresh", "1,url=/login.jsp");
                }
            } else if (type.equals("merchant")) {
                HashMap<String, Merchant> list = new HashMap<>();
                MerchantDao merchantDao = new MerchantDao();
                try {
                    list = merchantDao.getAllMerchant();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                for (Merchant merchant1 : list.values()) {
                    count++;
                    if (merchant1.getName().equals(acc) && merchant1.getPassword().equals(pwd)) {
                        session.setAttribute("user", acc);
                        response.getWriter().print("<p>Signing in</p>");
                        response.setHeader("refresh", "1,url=/bookStorage.jsp");
                        count--;//目的是处理列表的最后一个数据,确保count最后的值小于列表的长度
                        break;
                    }
                }
/*                System.out.println(list.size());
                System.out.println(count);*/
                if (count == list.size()) {
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print("<script> alert(\"账号或密码错误! \");</script>");
                    response.setHeader("refresh", "1,url=/login.jsp");
                }
            } else {
                String racc = "admin";
                String rpwd = "password";
                session.setAttribute("user", acc);
                if (acc.equals(racc) && pwd.equals(rpwd)) {
                    response.setHeader("refresh", "1,url=/showShopper.jsp");
                }
            }

        }
    }
}
