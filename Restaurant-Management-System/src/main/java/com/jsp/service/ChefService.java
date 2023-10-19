package com.jsp.service;

import java.util.List;

import com.jsp.dao.ChefDao;
import com.jsp.dto.Chef;

public class ChefService {
	
	ChefDao chefDao=new ChefDao();
	Chef chef=new Chef();
	
	public Chef addChef(Chef chef) {
		chef.setCh_status("unauthorized");
		return chefDao.addChef(chef);
	}

	public boolean delChef(int id) {
		return chefDao.delChef(id);
	}

	public Chef updateChefUnPw(int id, String new_un, String new_pw, String old_un, String old_pw) {

		List<Chef> chefs = chefDao.getChefs();
		for (Chef c : chefs) {
			if (old_un.equals(c.getCh_username()) && old_pw.equals(c.getCh_password())) {
				return chefDao.updateChefUnPw(id, new_un, new_pw);
			}
		}
		return null;
	}
	
	public Chef getChefById(int id) {
		return chefDao.getChefById(id);
	}
	
	public int getChefIdbyUn(String un) {
		return chefDao.getChefIdbyUn(un);
	}

	public boolean loginChef(String un, String pw) {
		return chefDao.loginChef(un, pw);
	}
	public List<Chef> getChefs() {
		return chefDao.getChefs();
	}
}
