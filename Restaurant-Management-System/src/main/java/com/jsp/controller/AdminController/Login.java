package com.jsp.controller.AdminController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.Chef;
import com.jsp.service.AdminService;
import com.jsp.service.ChefService;
@WebServlet("/adminLogin")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		AdminService adminService = new AdminService();	
		
		String un = req.getParameter("un");
		String pw = req.getParameter("pw");

		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("sessionname", un);
		httpSession.setAttribute("sessionpassword", pw);
		PrintWriter printWriter = resp.getWriter();
		
		boolean b=adminService.loginAdmin(un, pw);
		if(b) {
			printWriter.write("<html><body><h1>" + " Welcome "+ un + "</h1></body></html>");
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("adminDashboard.jsp");
			requestDispatcher.forward(req, resp);
			
		}
		else {
				printWriter.write("<html><body><h1>" + " username or password is wrong " + "</h1></body></html>");
		
		}
	}
}