package servlet;
import beans.Book;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        int bookCount = Integer.parseInt(request.getParameter("bookCount"));
        System.out.println(bookCount);
        ArrayList<Book> cart1 = (ArrayList<Book>) request.getSession().getAttribute("cart");
        HttpSession session = request.getSession();
        Double totalPrice;
        totalPrice = 0.0;
        for (Book book : cart1) {
            if (book.getId() == id) {
                book.setBookCount(Integer.parseInt(String.valueOf(bookCount)));
                totalPrice = totalPrice +book.getPrice()*bookCount;
            }
            else{
                totalPrice = totalPrice +book.getPrice()*book.getBookCount();
            }
        }
        session.setAttribute("cart", cart1);
        session.setAttribute("totalPrice", totalPrice);
//        new BookDao().updateAndDelete("update tb_books set bookCount='"+bookCount+"' where id='"+id+"'");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("<p>更新成功！</p>");
        response.setHeader("refresh", "1,url=/searchShopCart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
