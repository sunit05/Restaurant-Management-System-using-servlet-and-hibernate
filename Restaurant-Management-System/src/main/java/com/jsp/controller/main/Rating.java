package com.jsp.controller.main;


import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Menu;
import com.jsp.service.CartService;
import com.jsp.service.MenuService;
//import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/rating")
public class Rating extends HttpServlet {

	MenuService menuService = new MenuService();
	CartService cartService = new CartService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("stars") != null && req.getParameter("foodid") != null && req.getParameter("stars") != ""
				&& req.getParameter("foodid") != "") {
			double rating = Double.parseDouble(req.getParameter("stars"));
			int foodId = Integer.parseInt(req.getParameter("foodid"));
			Menu menu = menuService.getMenuById(foodId);
			if (menu != null) {
				menuService.updateRating(rating, foodId);
			}
		}
//		else {
//			PrintWriter printWriter = resp.getWriter();
//			printWriter.write("<html><body><h1>" + "Please enter valid details" + "</h1>"+"<a href='rating.jsp'>Go Back</a>"+"</body></html>");
//		}

		if (req.getParameter("logout") != null) {
			cartService.deleteAll();
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("logout_cust.jsp");
			requestDispatcher.forward(req, resp);
		} else {
//			Cookie cookie = new Cookie("check", "yes");
//			resp.addCookie(cookie);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("rating.jsp");
			requestDispatcher.forward(req, resp);
		}
	}
}