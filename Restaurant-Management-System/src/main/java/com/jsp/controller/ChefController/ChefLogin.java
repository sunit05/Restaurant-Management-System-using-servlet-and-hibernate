package com.jsp.controller.ChefController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.service.ChefService;
@WebServlet("/chefLogin")
public class ChefLogin extends HttpServlet {


		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			ChefService chefService = new ChefService();	
			
			String un = req.getParameter("un");
			String pw = req.getParameter("pw");
			PrintWriter printWriter = resp.getWriter();
			
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("chef_un", un);
			httpSession.setAttribute("chef_pw", pw);
			
			boolean b=chefService.loginChef(un, pw);
			if(b) {
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("checkOrder.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			else {
				printWriter.write("<html><body><h1>" + "chef's username or the password is wrong" + "</h1></body></html>");

			}
		}
	}
