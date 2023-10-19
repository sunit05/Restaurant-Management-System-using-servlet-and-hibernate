package com.jsp.service;

import java.util.List;

import com.jsp.dao.MenuDao;
import com.jsp.dto.Menu;

public class MenuService {

	MenuDao menuDao = new MenuDao();
	Menu menu = new Menu();

	public Menu addMenu(Menu menu) {
		return menuDao.addMenu(menu);
	}

	public boolean delMenu(int id) {
		return menuDao.delMenu(id);
	}

	public List<Menu> getMenus() {
		return menuDao.getMenus();
	}
	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);
	}
	public boolean updateRating(double star,int id) {

		return menuDao.updateRating(star, id);
	}

}
