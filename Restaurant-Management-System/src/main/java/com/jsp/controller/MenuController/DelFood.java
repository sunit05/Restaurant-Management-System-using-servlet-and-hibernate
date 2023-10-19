package com.jsp.controller.MenuController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.service.MenuService;

@WebServlet("/deleteFood")
public class DelFood extends HttpServlet {
	MenuService menuService = new MenuService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		if (menuService.delMenu(id)) {

			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " Successfully deleted the food" + "</h1></body></html>");

		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + " couldnt delete the food" + "</h1></body></html>");
		}
	}
}
