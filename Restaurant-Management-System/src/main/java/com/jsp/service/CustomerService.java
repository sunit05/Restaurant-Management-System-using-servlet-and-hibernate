package com.jsp.service;

import java.util.List;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;

public class CustomerService {
	
	CustomerDao customerDao=new CustomerDao();
	Customer customer=new Customer();
	
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	public boolean delCustomer(int id) {
		return customerDao.delCustomer(id);
	}

	public Customer getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}
}
