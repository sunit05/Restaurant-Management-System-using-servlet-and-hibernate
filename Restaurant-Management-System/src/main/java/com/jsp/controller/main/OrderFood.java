package com.jsp.controller.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.Cart;
import com.jsp.dto.Menu;
import com.jsp.service.CartService;
import com.jsp.service.MenuService;

@WebServlet("/orderF")
public class OrderFood extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuService menuService = new MenuService();
		CartService cartService = new CartService();
		Cart cart = new Cart();
		
		List<Integer> food_ids = new ArrayList<Integer>();
		if (req.getParameter("f_id") != null) {
			
			PrintWriter printWriter=resp.getWriter();
		
			int s = Integer.parseInt(req.getParameter("f_id"));
			food_ids.add(s);
		}
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("foodID", food_ids);
		
		List<Menu> menus = new ArrayList<Menu>();
		for (int f : food_ids) {
			menus.add(menuService.getMenuById(f));
		}
		cart.setMenus(menus);
		cart.setOrder_status("preparing");
		cartService.addCart(cart);
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("bill.jsp");
		requestDispatcher.forward(req, resp);
	}
}
