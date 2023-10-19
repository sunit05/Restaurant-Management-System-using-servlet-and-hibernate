package com.jsp.service;

import java.util.List;

import com.jsp.dao.AdminDao;
import com.jsp.dto.Admin;
import com.jsp.dto.Chef;

public class AdminService {
	AdminDao adminDao = new AdminDao();
	Admin admin = new Admin();

	public Admin addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	public boolean delAdmin(int id) {
		return adminDao.delAdmin(id);
	}

	public Admin updateAdminUnPw(int id, String new_un, String new_pw, String old_un, String old_pw) {

		List<Admin> admins = adminDao.getAdmins();
		for (Admin a : admins) {
			if (old_un.equals(a.getUsername()) && old_pw.equals(a.getPassword())) {
				return adminDao.updateAdminUnPw(id, new_un, new_pw);
			}
		}
		return null;
	}

	public int getAdminIdbyName(String un) {
		return adminDao.getAdminIdbyUn(un);
	}

	public boolean loginAdmin(String un, String pw) {
		return adminDao.loginAdmin(un, pw);
	}

	public boolean authChef(int id, Admin admin) {
		return adminDao.authChef(id, admin);

	}
	
	public Admin getAdminById(int id) {
		return adminDao.getAdminById(id);
	}
	public List<Admin> getAdmins() {
		return adminDao.getAdmins();
	}
		
}
