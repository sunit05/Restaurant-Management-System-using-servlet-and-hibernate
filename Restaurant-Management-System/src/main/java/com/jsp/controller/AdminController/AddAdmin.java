package com.jsp.controller.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

@WebServlet("/saveAdmin")
public class AddAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminService adminService = new AdminService();	
		
		String name = req.getParameter("name");
		String un = req.getParameter("un");
		String pw1 = req.getParameter("pw1");
		String pw2 = req.getParameter("pw2");

		if (pw1.equals(pw2)) {
			Admin admin = new Admin();

			admin.setName(name);
			admin.setUsername(un);
			admin.setPassword(pw1);

			Admin a = adminService.addAdmin(admin);
			if (a != null) {
				System.out.println("admin saved");
			}
		}
	}
}