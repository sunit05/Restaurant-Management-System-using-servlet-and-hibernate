package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Cart;

public class CartDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sunit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Cart cart = new Cart();

	public Cart addCart(Cart cart) {
		System.out.println("in add cart");
		entityTransaction.begin();
		entityManager.persist(cart);
		entityTransaction.commit();
		return cart;
	}

	public boolean delCart(int id) {
		Cart c = entityManager.find(Cart.class, id);

		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Cart getCartById(int id) {
		Cart c = entityManager.find(Cart.class, id);

		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	public List<Cart> getCarts() {
		String sql = "SELECT ch FROM Cart ch";
		Query query = entityManager.createQuery(sql);
		List<Cart> carts = query.getResultList();
		return carts;
	}

	public boolean deleteAll() {
		String sql = "SELECT ch FROM Cart ch";
		Query query = entityManager.createQuery(sql);
		List<Cart> carts = query.getResultList();
		if (carts != null) {
			for (Cart c : carts) {

				entityTransaction.begin();
				entityManager.remove(c);
				entityTransaction.commit();

			}
			return true;
		}
		return false;
	}
	
	public boolean updateStatus() {
		String sql = "SELECT ch FROM Cart ch";
		Query query = entityManager.createQuery(sql);
		List<Cart> carts = query.getResultList();
		if (carts != null) {
			for (Cart c : carts) {
				c.setOrder_status("Served");
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();

			}
			return true;
		}
		return false;
	}

	
}
