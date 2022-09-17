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
@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int top = 0;
        Double totalPrice = 0.0;
        HttpSession session = request.getSession();
        ArrayList<Book> cart = (ArrayList<Book>) request.getSession().getAttribute("cart");
        ArrayList<Book> cart1 = (ArrayList<Book>) new ArrayList<Book>();
        for(Book book:cart) {
            cart1.add(book);
            totalPrice = totalPrice + book.getPrice()* book.getBookCount();
            if(book.getId()==id){
                totalPrice = totalPrice - book.getPrice()*book.getBookCount();
                cart1.remove(top);
                top--;
            }
            top++;
        }
//        new BookDao().deleteId(id);
        session.setAttribute("totalPrice",totalPrice);
        session.setAttribute("cart",cart1);
        response.setHeader("refresh", "1,url=/searchShopCart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
