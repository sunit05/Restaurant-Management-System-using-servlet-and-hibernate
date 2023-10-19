package com.jsp.controller.CustomerController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		
		
		RequestDispatcher requestDispatcher = null;
		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("customer_session_name", name);
		
		Customer customer=new Customer();
		customer.setName(name);
		customer.setMail(mail);
		
		CustomerService customerService=new CustomerService();
		if(name== "" && mail=="") {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write("<html><body><h1>" + "please enter valid details" + "</h1></body></html>");

			
		}else if(customerService.addCustomer(customer)!=null) {
			requestDispatcher = req.getRequestDispatcher("orderFood.jsp");
			requestDispatcher.forward(req, resp);
			
			
		}
	}
}
