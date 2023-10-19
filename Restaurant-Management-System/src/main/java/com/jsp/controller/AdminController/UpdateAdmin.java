
package com.jsp.controller.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Admin;
import com.jsp.service.AdminService;

@WebServlet("/updateAdmin")
public class UpdateAdmin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminService adminService = new AdminService();
		
		String i=req.getParameter("id");
		String old_un=req.getParameter("old_un");
		String old_pw=req.getParameter("old_pw");
		String new_un=req.getParameter("new_un");
		String new_pw=req.getParameter("new_pw");
		int id=Integer.parseInt(i);
		
		Admin a = adminService.updateAdminUnPw(id,new_un,new_pw,old_un,old_pw); 
		if (a!=null) {
			System.out.println("successfully updated");
		} else {
			System.out.println("couldnt update");
		}
	}
}
