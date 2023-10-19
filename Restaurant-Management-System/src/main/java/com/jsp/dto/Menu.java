package com.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int f_id;
	private String f_name;
	private String f_category;
	private double f_cost;
	private double f_rating;
	private String f_description;

	@OneToOne
	private Chef chef;

	public String getF_description() {
		return f_description;
	}

	public void setF_description(String f_description) {
		this.f_description = f_description;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getF_category() {
		return f_category;
	}

	public void setF_category(String f_category) {
		this.f_category = f_category;
	}

	public double getF_cost() {
		return f_cost;
	}

	public void setF_cost(double f_cost) {
		this.f_cost = f_cost;
	}

	public double getF_rating() {
		return f_rating;
	}

	public void setF_rating(double f_rating) {
		this.f_rating = f_rating;
	}

}