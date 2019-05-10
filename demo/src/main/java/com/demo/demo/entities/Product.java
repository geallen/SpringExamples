package com.demo.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="productid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(name="productname")
	String productName;
	@Column(name="categoryid")
	int categoryId;
	@Column(name="unitprice")
	double unitPrice;
	@Column(name="description")
	String description;
	
	public Product() {
		
	}
	
	public Product(int productId, String productName, int categoryId, double unitPrice, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.unitPrice = unitPrice;
		this.description = description;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
