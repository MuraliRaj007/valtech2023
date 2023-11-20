package com.valtech.training.invoicespringboot.components;

public class Product {
	int productId;
	String productName;
	float productAmount;
	int manufactureId;

	public Product() {
		
	}

	public Product(String productName, float productAmount, int manufactureId) {
		this.productName = productName;
		this.productAmount = productAmount;
		this.manufactureId = manufactureId;
	}

	public Product(int productId, String productName, float productAmount, int manufactureId) {
		this.productId = productId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.manufactureId = manufactureId;
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

	public float getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(float productAmount) {
		this.productAmount = productAmount;
	}

	public int getManufactureId() {
		return manufactureId;
	}

	public void setManufactureId(int manufactureId) {
		this.manufactureId = manufactureId;
	}

}
