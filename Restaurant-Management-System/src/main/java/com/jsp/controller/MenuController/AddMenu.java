package com.jsp.controller.MenuController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Chef;
import com.jsp.dto.Menu;
import com.jsp.service.ChefService;
import com.jsp.service.MenuService;

@WebServlet("/addMenu")
public class AddMenu extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ChefService chefService = new ChefService();

		String f_name = req.getParameter("name");
		System.out.println(f_name);
		String f_category = req.getParameter("category");
		String cost=req.getParameter("cost");
		int f_cost=Integer.parseInt(cost);

		Menu menu = new Menu();

		MenuService menuService = new MenuService();
		if ( f_name != "" && f_category != "" && f_cost!=0 ) {
			System.out.println(f_name+ f_cost);
			menu.setF_name(f_name);
			menu.setF_category(f_category);
			menu.setF_cost(f_cost);
			
			menuService.addMenu(menu);
			
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " Successfully added the food" + "</h1></body></html>");

		} else if (menuService.addMenu(menu) == null && f_name == "" && f_category == "") {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " couldnt add the food" + "</h1></body></html>");
		}
	}

}
