package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Chef {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ch_id;
	private String ch_name;
	private String ch_username;
	private String ch_password;
	private String ch_status;
	
	@OneToOne
	private Admin admin;

	public int getCh_id() {
		return ch_id;
	}

	public void setCh_id(int ch_id) {
		this.ch_id = ch_id;
	}

	public String getCh_name() {
		return ch_name;
	}

	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}



	public String getCh_username() {
		return ch_username;
	}

	public void setCh_username(String ch_username) {
		this.ch_username = ch_username;
	}

	public String getCh_password() {
		return ch_password;
	}

	public void setCh_password(String ch_password) {
		this.ch_password = ch_password;
	}

	public String getCh_status() {
		return ch_status;
	}

	public void setCh_status(String ch_status) {
		this.ch_status = ch_status;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
