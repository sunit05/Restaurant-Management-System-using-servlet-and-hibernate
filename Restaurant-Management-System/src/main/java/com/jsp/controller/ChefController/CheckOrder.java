package com.jsp.controller.ChefController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.service.CartService;

@WebServlet("/checkOrder")
public class CheckOrder extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
		HttpSession httpSession=req.getSession();
		String un=(String)httpSession.getAttribute("chef_un");
		String pw=(String)httpSession.getAttribute("chef_pw");
		
		CartService cartService=new CartService();
		if(cartService.updateStatus()) {
			printWriter.write("<html><body><h1>" + " FOOD IS SERVED" + "</h1></body></html>");
			printWriter.write("<html><body><h1>" + "<a href='home.jsp'>LOGOUT AND RETURN HOME PAGE</a></h1></body></html>");
			httpSession.removeAttribute("chef_un");
			httpSession.removeAttribute("chef_pw");
			httpSession.invalidate();
			
		}
	}
}
