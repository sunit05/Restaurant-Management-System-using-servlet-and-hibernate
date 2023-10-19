package com.jsp.controller.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.CartService;
import com.jsp.service.IncomeService;
import com.jsp.service.MenuService;

@WebServlet("/bill")
public class BillPay extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IncomeService incomeService = new IncomeService();
		CartService cartService = new CartService();
		MenuService menuService = new MenuService();

		double s = (Double.parseDouble(req.getParameter("total")));
		if (req.getParameter("stars") != null) {
			int rateId = Integer.parseInt(req.getParameter("rate_id"));
			double rating = Double.parseDouble(req.getParameter("stars"));
			System.out.println("this is rateid"+rateId);
			System.out.println("tnis is star rating"+rating);
			menuService.updateRating(rating, rateId);
		}
		String pay = req.getParameter("pay");

		if (pay != null) {
			incomeService.updateIncome(s);
//			cartService.deleteAll();
		}

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("rating.jsp");
		requestDispatcher.forward(req, resp);

	}
}
