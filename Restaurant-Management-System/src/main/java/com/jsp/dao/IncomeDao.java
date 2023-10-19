package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Income;

public class IncomeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sunit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Income income=new Income();
	public boolean updateIncome(double income) {

		Income i = entityManager.find(Income.class, 1);
		if(i!=null) {
			double prev_income=i.getIncome();
			double new_income=income+prev_income;
			i.setIncome(new_income);
			entityTransaction.begin();
			entityManager.merge(i);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
}
