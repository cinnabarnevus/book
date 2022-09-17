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

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String)session.getAttribute("randStr");
        PrintWriter out = response.getWriter();
        if(!code.equals(randStr)) {
            System.out.println("code.equals(randStr)");
            out.print("<script> alert(\"验证码错误! \");</script>");
            response.setHeader("refresh", "1,url=/register.jsp");
        }else {
//            String type = request.getParameter("usertype");
            String name = request.getParameter("username");
            String password = request.getParameter("password");
//            if(type.equals("customer")) {
                User user = new User();
                user.setName(name);
                user.setPassword(password);
                String sql = "insert into tb_users(name,password) values(?,?)";
                UserDao cp = new UserDao();
                cp.insertUser(user, sql);
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("<script> alert(\"添加成功!\");</script>");
                response.setHeader("refresh", "1,url=register.jsp");
//            } else{
//                Merchant merchant = new Merchant();
//                merchant.setName(name);
//                merchant.setPassword(password);
//                String sql = "insert into tb_merchant(name,password) values(?,?)";
//                MerchantDao cp = new MerchantDao();
//                cp.insertMerchant(merchant, sql);
//                response.getWriter().print("<script> alert(\"添加成功!\");</script>");
//                response.setHeader("refresh", "1,url=register.jsp");

        }
    }
}
