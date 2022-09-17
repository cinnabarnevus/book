package servlet;

import beans.Book;
import beans.Shop;
import dao.BookDao;
import dao.ShopDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/DeleteShopper")
public class DeleteShopper extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HashMap<String, Shop> list = (HashMap<String, Shop>) req.getSession().getAttribute("list");
        list.remove(id);
        new ShopDao().deleteId(id);
        req.getRequestDispatcher("showShopper.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
