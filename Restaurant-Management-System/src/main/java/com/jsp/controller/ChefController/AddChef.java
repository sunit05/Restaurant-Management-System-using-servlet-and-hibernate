package com.jsp.controller.ChefController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Chef;
import com.jsp.dto.Chef;
import com.jsp.service.ChefService;

@WebServlet("/addChef")
public class AddChef extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Chef chef = new Chef();
		ChefService chefService = new ChefService();

		String name = req.getParameter("name");
		String un = req.getParameter("un");
		String pw1 = req.getParameter("pw1");
		String pw2 = req.getParameter("pw2");
		if (pw1.equals(pw2)) {

			chef.setCh_name(name);
			chef.setCh_username(un);
			chef.setCh_password(pw1);

			Chef a = chefService.addChef(chef);
			if (a != null) {
				System.out.println("chef saved");
			}
		}
	}
}
