package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Chef;

public class ChefDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sunit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Chef chef=new Chef();

	public Chef addChef(Chef chef) {
		entityTransaction.begin();
		entityManager.persist(chef);
		entityTransaction.commit();
		return chef;
	}

	public boolean delChef(int id) {
		Chef c = entityManager.find(Chef.class, id);

		if (c != null) {
			entityTransaction.begin();
			entityManager.remove(c);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Chef getChefById(int id) {
		Chef c = entityManager.find(Chef.class, id);

		if (c != null) {
			return c;
		} else {
			return null;
		}
	}

	public int getChefIdbyUn(String un) {
		String sql = "SELECT ch FROM Chef ch";
		int id = 0;
		Query query = entityManager.createQuery(sql);

		List<Chef> chefs = query.getResultList();
		for (Chef c : chefs) {
			if (un.equals(chef.getCh_username())) {
				id = c.getCh_id();
				return id;
			}
		}
		return 0;
	}

	public Chef updateChefUnPw(int id, String new_un, String new_pw) {

		Chef c = entityManager.find(Chef.class, id);

		if (c != null) {
			c.setCh_username(new_un);
			c.setCh_password(new_pw);
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
			return c;
		}
		return null;
	}

	public boolean loginChef(String un, String pw) {
		String sql = "SELECT ch FROM Chef ch";
		Query query = entityManager.createQuery(sql);

		List<Chef> chefs = query.getResultList();
		for (Chef c : chefs) {
			if (un.equals(c.getCh_username()) && pw.equals(c.getCh_password())) {
				return true;
			}
		}
		return false;
	}

	public List<Chef> getChefs() {
		String sql = "SELECT ch FROM Chef ch";
		Query query = entityManager.createQuery(sql);
		List<Chef> chefs = query.getResultList();
		return chefs;
	}

}
