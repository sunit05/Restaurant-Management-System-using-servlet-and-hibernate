package com.jsp.controller.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class HomeController extends HttpServlet

{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = null;
		if (req.getParameter("adminLogin") != null) {
			requestDispatcher = req.getRequestDispatcher("adminLogin.jsp");
			requestDispatcher.forward(req, resp);
		} else if (req.getParameter("chefLogin") != null) {
			requestDispatcher = req.getRequestDispatcher("chefLogin.jsp");
			requestDispatcher.forward(req, resp);
		} else if (req.getParameter("customerLogin") != null) {
			requestDispatcher = req.getRequestDispatcher("addCustomer.jsp");
			requestDispatcher.forward(req, resp);
		}
	}

}
