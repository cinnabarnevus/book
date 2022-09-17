package servlet;
import beans.Shop;
import dao.ShopDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddShopper")
public class AddShopper extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Shop shop = new Shop();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int phone = Integer.parseInt(request.getParameter("phone"));
        shop.setName(name);
        shop.setId(id);
        shop.setAddress(address);
        shop.setPhone(phone);
        String sql = "insert into tb_shoper(id,name,phone,address) values(?,?,?,?)";
        ShopDao shopDao = new ShopDao();
        shopDao.insertRecord(shop,sql);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<script> alert(\"添加成功! \");</script>");
        response.setHeader("refresh", "1,url=addShopper.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
