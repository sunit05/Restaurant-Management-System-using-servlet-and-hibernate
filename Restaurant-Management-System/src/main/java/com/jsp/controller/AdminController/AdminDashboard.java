package com.jsp.controller.AdminController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/adminDash")
public class AdminDashboard extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher requestDispatcher = null;
		HttpSession httpSession=req.getSession();
		
		if (req.getParameter("viewChef") != null) {
			requestDispatcher = req.getRequestDispatcher("checkAllChef.jsp");
			requestDispatcher.forward(req, resp);
		} else if (req.getParameter("viewMenu") != null) {
			requestDispatcher = req.getRequestDispatcher("menuView.jsp");
			requestDispatcher.forward(req, resp);
		} else if (req.getParameter("addFood") != null) {
			requestDispatcher = req.getRequestDispatcher("addMenu.jsp");
			requestDispatcher.forward(req, resp);
		} else if (req.getParameter("removeFood") != null) {
			requestDispatcher = req.getRequestDispatcher("delFood.jsp");
			requestDispatcher.forward(req, resp);
		} else if(req.getParameter("logout")!= null) {

			requestDispatcher = req.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(req, resp);
			
			String s=(String)httpSession.getAttribute("sessionname");
			httpSession.removeAttribute(s);
			httpSession.invalidate();
		
		
		}
		}
	}

	
	
