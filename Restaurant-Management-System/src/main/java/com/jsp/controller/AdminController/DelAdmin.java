package com.jsp.controller.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.AdminService;

@WebServlet("/deleteAdmin")
public class DelAdmin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminService adminService = new AdminService();

		String i = req.getParameter("id");
		String un = req.getParameter("un");
		String pw = req.getParameter("pw");
		int id = Integer.parseInt(i);

		boolean b = adminService.delAdmin(id);
		
	}

}