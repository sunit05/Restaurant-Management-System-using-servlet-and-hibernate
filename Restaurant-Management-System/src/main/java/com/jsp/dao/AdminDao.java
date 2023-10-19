package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Admin;
import com.jsp.dto.Chef;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sunit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Admin admin = new Admin();

	public Admin addAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

	public boolean delAdmin(int id) {
		Admin a = entityManager.find(Admin.class, id);

		if (a != null) {
			entityTransaction.begin();
			entityManager.remove(a);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Admin getAdminById(int id) {
		Admin a = entityManager.find(Admin.class, id);

		if (a != null) {
			return a;
		} else {
			return null;
		}
	}

	public int getAdminIdbyUn(String un) {
		String sql = "SELECT ad FROM Admin ad";
		int id = 0;
		Query query = entityManager.createQuery(sql);

		List<Admin> admins = query.getResultList();
		for (Admin a : admins) {
			if (un.equals(admin.getUsername())) {
				id = a.getId();
				return id;
			}
		}
		return 0;
	}

	public Admin updateAdminUnPw(int id, String new_un, String new_pw) {

		Admin a = entityManager.find(Admin.class, id);

		if (a != null) {
			a.setUsername(new_un);
			a.setPassword(new_pw);
			entityTransaction.begin();
			entityManager.merge(a);
			entityTransaction.commit();
			return a;
		}
		return null;
	}

	public boolean loginAdmin(String un, String pw) {
		String sql = "SELECT ad FROM Admin ad";
		Query query = entityManager.createQuery(sql);

		List<Admin> admins = query.getResultList();
		for (Admin a : admins) {
			if (un.equals(a.getUsername()) && pw.equals(a.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public List<Admin> getAdmins() {
		String sql = "SELECT ad FROM Admin ad";
		Query query = entityManager.createQuery(sql);
		List<Admin> admins = query.getResultList();
		return admins;
	}

	public boolean authChef(int c_id, Admin admin) {
		Chef c = entityManager.find(Chef.class, c_id);
		if (c != null) {
			c.setCh_status("authorized");
			c.setAdmin(admin);
			entityTransaction.begin();
			entityManager.merge(c);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
