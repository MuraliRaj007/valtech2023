package com.valtech.training.invoicespringboot.components;

public class OrderSummary {
	int id;
	int productId;
	int productQuantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public OrderSummary() {

	}

	public OrderSummary(int id, int productId, int productQuantity) {
		this.id = id;
		this.productId = productId;
		this.productQuantity = productQuantity;
	}

	public OrderSummary(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public int getProductQuantity() {
		return productQuantity;
	}



	

}
