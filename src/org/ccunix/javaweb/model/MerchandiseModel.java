package org.ccunix.javaweb.model;

import java.io.Serializable;

public class MerchandiseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int category;
	private String mername;
	private double price;
	private double sprice;
	private String picture;
	private String merdesc;
	private String manufacturer;
	private String mermodel;
	private String leavefactorydate;
	private int special;

	private CategoryModel categoryModel;//m:1
	public MerchandiseModel() {

	}

	public MerchandiseModel(int id, int category, String mername, double price, double sprice, String picture,
			String merdesc, String manufacturer, String leavefactorydate, String mermodel, int special) {
		this.id = id;
		this.category = category;
		this.mername = mername;
		this.price = price;
		this.sprice = sprice;
		this.picture = picture;
		this.merdesc = merdesc;
		this.manufacturer = manufacturer;
		this.leavefactorydate = leavefactorydate;
		this.mermodel = mermodel;
		this.special = special;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getMername() {
		return mername;
	}

	public void setMername(String mername) {
		this.mername = mername;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSprice() {
		return sprice;
	}

	public void setSprice(double sprice) {
		this.sprice = sprice;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getMerdesc() {
		return merdesc;
	}

	public void setMerdesc(String merdesc) {
		this.merdesc = merdesc;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLeavefactorydate() {
		return leavefactorydate;
	}

	public void setLeavefactorydate(String leavefactorydate) {
		this.leavefactorydate = leavefactorydate;
	}

	public String getMermodel() {
		return mermodel;
	}

	public void setMermodel(String mermodel) {
		this.mermodel = mermodel;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

}