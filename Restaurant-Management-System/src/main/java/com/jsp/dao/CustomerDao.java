package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Customer;


public class CustomerDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sunit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Customer customer = new Customer();

	public Customer addCustomer(Customer customer) {
		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
	}

	public boolean delCustomer(int id) {
		Customer c = entityManager.find(Customer.class, id);

		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Customer getCustomerById(int id) {
		Customer c = entityManager.find(Customer.class, id);

		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	public List<Customer> getCustomers() {
		String sql = "SELECT ch FROM Customer ch";
		Query query = entityManager.createQuery(sql);
		List<Customer> customers = query.getResultList();
		return customers;
	}

}
