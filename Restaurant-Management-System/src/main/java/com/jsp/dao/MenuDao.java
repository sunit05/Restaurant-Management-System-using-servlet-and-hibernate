package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Menu;

public class MenuDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sunit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Menu menu = new Menu();

	public Menu addMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	public boolean delMenu(int id) {
		Menu c = entityManager.find(Menu.class, id);

		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Menu getMenuById(int id) {
		Menu c = entityManager.find(Menu.class, id);

		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	public List<Menu> getMenus() {
		String sql = "SELECT ch FROM Menu ch";
		Query query = entityManager.createQuery(sql);
		List<Menu> menus = query.getResultList();
		return menus;
	}

	public boolean updateRating(double star, int id) {
		Menu c = entityManager.find(Menu.class, id);
		if (c != null) {
			if (c.getF_rating() < 0.5) {
				System.out.println(c.getF_id()+"in if this is food in dao");
				c.setF_rating(star);

				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			} else {
				double prev_rate = c.getF_rating();
				
				c.setF_rating((star + prev_rate) / 2.0);
				System.out.println(c.getF_id()+"in else this is food in dao");
				
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			}
			return true;
		}
		return false;
	}

}
