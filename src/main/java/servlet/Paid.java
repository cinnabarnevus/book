package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Book;


/**
 * Servlet implementation class Paid
 */
@WebServlet("/Paid")
public class Paid extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] checked = request.getParameterValues("check");//check代表购买图书的id
		ArrayList<Book> cart = (ArrayList<Book>) session.getAttribute("cart");//cart代表购物车
		ArrayList<Book> list2 = (ArrayList<Book>) session.getAttribute("list2");//list2代表书库
		for (String i : checked)
		{
			//如果购买的数量刚好等于库存数量，就该品类商品从库存中删除
			int id = Integer.valueOf(i);
			int coun = list2.get(id).getBookCount();
			coun -= cart.get(id).getBookCount();
			if(coun==0)
				list2.remove(id);
			else 
				list2.get(id).setBookCount(coun);
		}
		response.sendRedirect("/paid.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
